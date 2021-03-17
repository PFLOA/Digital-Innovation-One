# Solução de Problemas Essenciais

### (1/5) [Quadrado e ao Cubo](https://github.com/PFLOA/everis-FullStack/blob/main/Desafios/Solu%C3%A7%C3%A3o%20de%20Problemas%20Essenciais/quadrado_cubo.js)

Você terá o desafio de escrever um programa que leia um valor inteiro N (1 <br N <br 1000). Este N é a quantidade de linhas de saída que serão apresentadas na execução do programa.

**Entrada**

O arquivo de entrada contém um número inteiro positivo N.

**Saída**

Imprima a saída conforme o exemplo fornecido.
</br>
| Exemplos de entrada | Exemplos de saída |
| :-----------------: | ----------------- |
|          5          | 1 1 1             |
|                     | 2 4 8             |
|                     | 3 9 27            |
|                     | 4 16 64           |
|                     | 5 25 125          |

---

### (2/5) [A Corrida de Tartarugas](https://github.com/PFLOA/everis-FullStack/blob/main/Desafios/Solu%C3%A7%C3%A3o%20de%20Problemas%20Essenciais/corrida_tartarugas.js)

A corrida de tartarugas é um esporte que cresceu muito nos últimos anos, fazendo com que vários competidores se dediquem a capturar tartarugas rápidas, e treina-las para faturar milhões em corridas pelo mundo. Porém a tarefa de capturar tartarugas não é uma tarefa muito fácil, pois quase todos esses répteis são bem lentos. Cada tartaruga é classificada em um nível dependendo de sua velocidade:


Nível 1: Se a velocidade é menor que 10 cm/h .
Nível 2: Se a velocidade é maior ou igual a 10 cm/h e menor que 20 cm/h .
Nível 3: Se a velocidade é maior ou igual a 20 cm/h .

Sua tarefa é identificar qual o nível de velocidade da tartaruga mais veloz de um grupo.

**Entrada**

A entrada consiste de múltiplos casos de teste, e cada um consiste em duas linhas: A primeira linha contém um inteiro L (1 ≤ L ≤ 500) representando o número de tartarugas do grupo, e a segunda linha contém L inteiros Vi (1 ≤ Vi ≤ 50) representando as velocidades de cada tartaruga do grupo.

**Saída**

Para cada caso de teste, imprima uma única linha indicando o nível de velocidade da tartaruga mais veloz do grupo.
</br>
| Exemplos de entrada                  | Exemplos de saída |
| ------------------------------------ | ----------------- |
| 10</br>10 10 10 10 15 18 20 15 11 10 | 3                 |
| 10</br>1 5 2 9 5 5 8 4 4 3           | 1                 |
| 10</br>19 9 1 4 5 8 6 11 9 7         | 2                 |

---

### (3/5) [Ultrapassando V](https://github.com/PFLOA/everis-FullStack/blob/main/Desafios/Solu%C3%A7%C3%A3o%20de%20Problemas%20Essenciais/ultrapassando_v.js)

Como um bom desenvolvedor, você precisa fazer um programa que leia dois ingeiros: R e V (devem ser lidos tantos valores para V quantos necessários, até que seja digitado um valor maior do que R para ele). Conte quantos números inteiros devem ser somados em sequência (considerando o R nesta soma) para que a soma ultrapasse a V o mínimo possível. Escreva o valor final da contagem.

A entrada pode conter, por exemplo, os valores 21 21 15 30. Neste caso, é então assumido o valor 21 para R enquanto os valores 21 e 15 devem ser desconsiderados pois são menores ou iguais a R. Como o valor 30 está dentro da especificação (maior do que R) ele será válido e então deve-se processar os cálculos para apresentar na saída o valor 2, pois é a quantidade de valores somados para se produzir um valor maior do que 30 (21 + 22).

**Entrada**

A entrada contém somente valores inteiros, um por linha, podendo ser positivos ou negativos. O primeiro valor da entrada será o valor de R. A próxima linha da entrada irá conter V. Se V não atender a especificação do problema, ele deverá ser lido novamente, tantas vezes quantas forem necessárias.

**Saída**

Imprima uma linha com um número inteiro que representa a quantidade de números inteiros que devem ser somadas, de acordo com a especificação acima.
</br>
| Exemplos de entrada | Exemplos de saída |
| :-----------------: | ----------------- |
|   3</br>1</br>20    | 5                 |

---

### (4/5) [Validação de Nota](https://github.com/PFLOA/everis-FullStack/blob/main/Desafios/Solu%C3%A7%C3%A3o%20de%20Problemas%20Essenciais/validacao_notas.js)

Para ajudar a calcular as notas referentes às duas avaliações dos alunos, uma professora pediu para que você desenvolva um programa que calcule e imprima a média semestral. Faça com que o algoritmo só aceite notas válidas (uma nota válida deve pertencer ao intervalo [0,10]). Cada nota deve ser validada separadamente.

**Entrada**

A entrada contém vários valores reais, positivos ou negativos. O programa deve ser encerrado quando forem lidas duas notas válidas.

**Saída**

Se uma nota inválida  for lida, deve ser impressa a mensagem "nota invalida".
Quando duas notas válidas forem lidas, deve ser impressa a mensagem "media = " seguido do valor do cálculo. O valor deve ser apresentado com duas casas após o ponto decimal.
</br>
| Exemplos de entrada | Exemplos de saída |
| :-----------------: | ----------------- |
|   -3.5</br>3.5</br>11</br>10    | nota invalida</br>nota invalida</br>6.75                 |

---

### (5/5) [Pedro Bento e o Mundo de OZ](https://github.com/PFLOA/everis-FullStack/blob/main/Desafios/Solu%C3%A7%C3%A3o%20de%20Problemas%20Essenciais/pedro_bento_mundo_oz.js)

No jogo, O Mundo de Oz, Pedro Bento é o líder do Tribunal, por causa disso ele é uma das pessoas mais importantes do mundo, no jogo. Além disso, Pedro Bento possui um grande tesouro, o qual possui diversos tipos de jóias.

Pedro Bento está muito curioso para saber quantos tipos de jóias diferentes seu tesouro possui.

Sabendo que você é o melhor programador do mundo, Pedro Bento te contratou para verificar quantos tipos de jóias distintas ele tem em seu tesouro.

**Entrada**

A entrada consiste de várias linhas e cada uma contém uma string que descreve uma das jóias de Pedro Bento. Essa string é composta apenas dos caracteres '(' e ')', a soma do tamanho de todas as string não excede 106.

**Saída**

Imprima quantos tipos de jóias distintas Pedro Bento possui.
</br>
|      Exemplos de entrada      | Exemplos de saída |
| :---------------------------: | :---------------: |
| ((</br>))</br>((</br>))</br>( |         3         |
