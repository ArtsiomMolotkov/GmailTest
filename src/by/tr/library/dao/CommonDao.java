package by.tr.library.dao;

import by.tr.library.dao.exception.DAOException;

public interface CommonDao {
	boolean logination(String login, String password) throws DAOException;
	boolean registration(String login, String password) throws DAOException;
}
