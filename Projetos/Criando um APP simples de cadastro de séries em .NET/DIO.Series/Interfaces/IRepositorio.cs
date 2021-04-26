using System.Collections.Generic;

namespace DIO.Series.Interfaces
{
    public interface IRepositorio<T>
    {
        ///<summary>
        /// Lista baseada na entidade passada por parametro.
        ///</summary>
        ///<return>Retorna lista.</return>
         List<T> Lista();

         ///<summary>
        ///
        ///</summary>
         T RetornaPorId(int id);

         ///<summary>
        ///
        ///</summary>
         void Insere(T entidade);

         ///<summary>
        ///
        ///</summary>
         void Excluir(int id);

         ///<summary>
        ///
        ///</summary>
         void Atualizar(int id, T entidade);

         ///<summary>
        ///
        ///</summary>
         int ProximoId();
    }
}