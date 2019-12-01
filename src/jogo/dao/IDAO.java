package jogo.dao;

/**
 * Interface para padronização dos DAOs
 *
 * @param <T> Tipo de objeto manipulado pelo DAO
 */
public interface IDAO<T> {

    /**
     * Inserir objeto no banco de dados.
     *
     * @param obj Objeto a ser inserido.
     */
    public void inserir(T obj);

    /**
     * Alterar objeto no banco de dados.
     *
     * @param obj Objeto a ser aterado.
     */
    public void alterar(T obj);

    /**
     * Excluir objeto do banco de dados.
     *
     * @param obj Objeto a ser deletado.
     */
    public void excluir(T obj);
}
