package jogo.dao;

import java.sql.SQLException;

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
     * @param idMatch
     * @throws java.sql.SQLException
     */
    public void inserir(T obj, int id)throws SQLException;

    /**
     * Alterar objeto no banco de dados.
     *
     * @param obj Objeto a ser aterado.
     * @throws java.sql.SQLException
     */
    public void alterar(T obj)throws SQLException;

    /**
     * Excluir objeto do banco de dados.
     *
     * @param obj Objeto a ser deletado.
     * @throws java.sql.SQLException
     */
    public void excluir(T obj)throws SQLException;
}
