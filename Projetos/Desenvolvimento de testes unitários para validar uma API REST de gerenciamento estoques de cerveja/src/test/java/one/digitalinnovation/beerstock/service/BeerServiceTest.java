package one.digitalinnovation.beerstock.service;

import one.digitalinnovation.beerstock.builder.BeerDTOBuilder;
import one.digitalinnovation.beerstock.dto.BeerDTO;
import one.digitalinnovation.beerstock.entity.Beer;
import one.digitalinnovation.beerstock.exception.BeerAlreadyRegisteredException;
import one.digitalinnovation.beerstock.exception.BeerNotFoundException;
import one.digitalinnovation.beerstock.exception.BeerStockExceededException;
import one.digitalinnovation.beerstock.mapper.BeerMapper;
import one.digitalinnovation.beerstock.repository.BeerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BeerServiceTest {

    private static final long INVALID_BEER_ID = 1L;

    @Mock
    private BeerRepository beerRepository;

    private BeerMapper beerMapper = BeerMapper.INSTANCE;

    @InjectMocks
    private BeerService beerService;

    @Test
    void whenBeerInformedThenItShouldBeCreated() throws BeerAlreadyRegisteredException {
        //given
        BeerDTO beerDto = BeerDTOBuilder.builder().build().toBeerDTO();
        Beer expectedSavedbeer = beerMapper.toModel(beerDto);

        //when
        when(beerRepository.findByName(beerDto.getName())).thenReturn(Optional.empty());
        when(beerRepository.save(expectedSavedbeer)).thenReturn(expectedSavedbeer);

        //then
        BeerDTO createdBeerDTO = beerService.createBeer(beerDto);

        //matchers
        assertThat(createdBeerDTO.getId(), is(equalTo(beerDto.getId())));
        assertThat(createdBeerDTO.getName(), is(equalTo(beerDto.getName())));
        assertThat(createdBeerDTO.getQuantity(), is(equalTo(beerDto.getQuantity())));

        //jupiter
        assertEquals(beerDto.getId(), createdBeerDTO.getId());
        assertEquals(beerDto.getName(), createdBeerDTO.getName());
    }

    @Test
    void whenAlreadyRegisteredBeerInformedThenAnExceptionShouldBeThrown() throws BeerAlreadyRegisteredException {
        //given
        BeerDTO beerDTO = BeerDTOBuilder.builder().build().toBeerDTO();
        Beer duplicatedBeer = beerMapper.toModel(beerDTO);

        //when
        when(beerRepository.findByName(beerDTO.getName())).thenReturn(Optional.of(duplicatedBeer));

        //then
        assertThrows(BeerAlreadyRegisteredException.class, () ->
                beerService.createBeer(beerDTO));
    }

    @Test
    void whenValidBeerNameIsGivenThenReturnABeer() throws BeerNotFoundException {
        //given
        BeerDTO beerDTO = BeerDTOBuilder.builder().build().toBeerDTO();
        Beer beer = beerMapper.toModel(beerDTO);

        //when
        when(beerRepository.findByName(beer.getName())).thenReturn(Optional.of(beer));

        //then
        BeerDTO foundBeerDto = beerService.findByName(beerDTO.getName());

        assertThat(foundBeerDto, is(equalTo(beerDTO)));
    }

    @Test
    void whenNotRegisteredBeerNameIsGivenThenThrownAnException() throws BeerNotFoundException {
        //given
        BeerDTO expectedBeerDTO = BeerDTOBuilder.builder().build().toBeerDTO();

        //when
        when(beerRepository.findByName(expectedBeerDTO.getName())).thenReturn(Optional.empty());

        //then
        assertThrows(BeerNotFoundException.class, () -> beerService.findByName((expectedBeerDTO.getName())));
    }

    @Test
    void whenListOfBeerIsCalledThenReturnAlistOfBeer(){
        //given
        BeerDTO beerDTO = BeerDTOBuilder.builder().build().toBeerDTO();
        Beer beer = beerMapper.toModel(beerDTO);

        //when
        when(beerRepository.findAll()).thenReturn(Collections.singletonList(beer));

        //then
        List<BeerDTO> foundBeerDTO = beerService.listAll();

        assertThat(foundBeerDTO, is(not(empty())));
        assertThat(foundBeerDTO.get(0), is(equalTo(beerDTO)));
    }

    @Test
    void whenListOfBeerIsCalledThenReturnAEmptylistOfBeer(){
        //when
        when(beerRepository.findAll()).thenReturn(Collections.EMPTY_LIST);

        //then
        List<BeerDTO> foundBeerDTO = beerService.listAll();

        assertThat(foundBeerDTO, is(empty()));
    }

    @Test
    void whenDeleteIsCalledWithValidIdThenBeerShouldBeDeleted() throws BeerNotFoundException {
        //given
        BeerDTO expectedDeleteBeerDto = BeerDTOBuilder.builder().build().toBeerDTO();
        Beer expectedDeleteBeer = beerMapper.toModel(expectedDeleteBeerDto);

        //when
        when(beerRepository.findById(expectedDeleteBeerDto.getId())).thenReturn(Optional.of(expectedDeleteBeer));
        doNothing().when(beerRepository).deleteById(expectedDeleteBeerDto.getId());

        //then
        beerService.deleteById(expectedDeleteBeerDto.getId());
        verify(beerRepository, times(1)).findById(expectedDeleteBeer.getId());
        verify(beerRepository, times(1)).deleteById(expectedDeleteBeer.getId());
    }

    @Test
    void whenIncrementIsCalledThenIncrmentBeenStock() throws BeerNotFoundException, BeerStockExceededException {
        //given
        BeerDTO expectedBeerDto = BeerDTOBuilder.builder().build().toBeerDTO();
        Beer expectedBeer = beerMapper.toModel(expectedBeerDto);

//        //when
        when(beerRepository.findById(expectedBeerDto.getId())).thenReturn(Optional.of(expectedBeer));
        when(beerRepository.save(expectedBeer)).thenReturn(expectedBeer);

        int quantityToIncrement = 10;
        int expectedQuantityAfterIncrement = expectedBeerDto.getQuantity() + quantityToIncrement;

        //then
        BeerDTO incrementBeerDto = beerService.increment(expectedBeerDto.getId(), quantityToIncrement);

        assertThat(expectedQuantityAfterIncrement, equalTo(incrementBeerDto.getQuantity()));
        assertThat(expectedQuantityAfterIncrement, lessThan(incrementBeerDto.getMax()));
    }

    @Test
    void whenIncrementIsGreaterThanMaxQuantityOfStockThrowException(){
        //given
        BeerDTO expectedBeerDto = BeerDTOBuilder.builder().build().toBeerDTO();
        Beer expectedBeer = beerMapper.toModel(expectedBeerDto);

        //when
        when(beerRepository.findById(expectedBeerDto.getId())).thenReturn(Optional.of(expectedBeer));

        int quantityToIncrement = 80;

        //then
        assertThrows(BeerStockExceededException.class, () -> beerService.increment(expectedBeerDto.getId(), quantityToIncrement));

    }
    @Test
    void whenIncrementAfterSumIsGreaterThanMaxQuantityOfStockThrowException(){
        //given
        BeerDTO expectedBeerDto = BeerDTOBuilder.builder().build().toBeerDTO();
        Beer expectedBeer = beerMapper.toModel(expectedBeerDto);

        //when
        when(beerRepository.findById(expectedBeerDto.getId())).thenReturn(Optional.of(expectedBeer));

        int quantityToIncrement = 45;

        //then
        assertThrows(BeerStockExceededException.class, () -> beerService.increment(expectedBeerDto.getId(), quantityToIncrement));

    }

    @Test
    void whenIncrementIsCalledWithInvalidIdThenThrowException(){
        int quantity = 10;

        //when
        when(beerRepository.findById(INVALID_BEER_ID)).thenReturn(Optional.empty());

        assertThrows(BeerNotFoundException.class, ()-> beerService.increment(INVALID_BEER_ID, quantity));
    }

//    @Test
//    void whenDecrementIsCalledThenDecrementBeerStock() throws BeerNotFoundException, BeerStockExceededException {
//        BeerDTO expectedBeerDTO = BeerDTOBuilder.builder().build().toBeerDTO();
//        Beer expectedBeer = beerMapper.toModel(expectedBeerDTO);
//
//        when(beerRepository.findById(expectedBeerDTO.getId())).thenReturn(Optional.of(expectedBeer));
//        when(beerRepository.save(expectedBeer)).thenReturn(expectedBeer);
//
//        int quantityToDecrement = 5;
//        int expectedQuantityAfterDecrement = expectedBeerDTO.getQuantity() - quantityToDecrement;
//
//        //then
//        BeerDTO incrementedBeerDTO = beerService.decrement(expectedBeerDTO.getId(), quantityToDecrement);
//
//        assertThat(expectedQuantityAfterDecrement, equalTo(incrementedBeerDTO.getQuantity()));
//        assertThat(expectedQuantityAfterDecrement, greaterThan(0));
//    }
//
//    @Test
//    void whenDecrementIsCalledToEmptyStockThenEmptyBeerStock() throws BeerNotFoundException, BeerStockExceededException {
//        BeerDTO expectedBeerDTO = BeerDTOBuilder.builder().build().toBeerDTO();
//        Beer expectedBeer = beerMapper.toModel(expectedBeerDTO);
//
//        when(beerRepository.findById(expectedBeerDTO.getId())).thenReturn(Optional.of(expectedBeer));
//        when(beerRepository.save(expectedBeer)).thenReturn(expectedBeer);
//
//        int quantityToDecrement = 10;
//        int expectedQuantityAfterDecrement = expectedBeerDTO.getQuantity() - quantityToDecrement;
//        BeerDTO incrementedBeerDTO = beerService.decrement(expectedBeerDTO.getId(), quantityToDecrement);
//
//        assertThat(expectedQuantityAfterDecrement, equalTo(0));
//        assertThat(expectedQuantityAfterDecrement, equalTo(incrementedBeerDTO.getQuantity()));
//    }
//
//    @Test
//    void whenDecrementIsLowerThanZeroThenThrowException() {
//        BeerDTO expectedBeerDTO = BeerDTOBuilder.builder().build().toBeerDTO();
//        Beer expectedBeer = beerMapper.toModel(expectedBeerDTO);
//
//        when(beerRepository.findById(expectedBeerDTO.getId())).thenReturn(Optional.of(expectedBeer));
//
//        int quantityToDecrement = 80;
//        assertThrows(BeerStockExceededException.class, () -> beerService.decrement(expectedBeerDTO.getId(), quantityToDecrement));
//    }
//
//    @Test
//    void whenDecrementIsCalledWithInvalidIdThenThrowException() {
//        int quantityToDecrement = 10;
//
//        when(beerRepository.findById(INVALID_BEER_ID)).thenReturn(Optional.empty());
//
//        assertThrows(BeerNotFoundException.class, () -> beerService.decrement(INVALID_BEER_ID, quantityToDecrement));
//    }
}
