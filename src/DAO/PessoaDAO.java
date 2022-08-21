package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Connection.ConnectionFactory;
import Models.Pessoa;

public class PessoaDAO {

	private Connection conn;
	
	public PessoaDAO() {
		conn = new ConnectionFactory().getConnection();
	}
	
	public boolean Insert(Pessoa pessoa) throws Exception {
		try {
			String sqlInsert = "INSERT INTO Pessoa (name,email) VALUES (?,?)";
			PreparedStatement prepStat = conn.prepareStatement(sqlInsert);
			prepStat.setString(1, pessoa.getNome());
			prepStat.setString(2, pessoa.getEmail());
			prepStat.execute();
			prepStat.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e);
//			return false;
		}finally {
			conn.close();
		}
	}
	
	public List<Pessoa> list() throws Exception {
		try {
			List<Pessoa> pessoas = new ArrayList();
			String sqlList = "SELECT * FROM Pessoa";
			PreparedStatement pstmt = conn.prepareStatement(sqlList);
			ResultSet resultset = pstmt.executeQuery();
			
			while(resultset.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setId(resultset.getInt("id"));
				pessoa.setNome(resultset.getString("name"));
				pessoa.setEmail(resultset.getString("email"));
				
				pessoas.add(pessoa);
			}
			return pessoas;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e);
		}finally {
			conn.close();
		}
	}
	
	public boolean Delete(int idPessoa) throws Exception {
		try {
			String sqlDel = "DELETE FROM Pessoa  WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sqlDel);
			pstmt.setInt(1, idPessoa);
			pstmt.execute();
			pstmt.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e);
		}finally {
			conn.close();
		}
	}
	
	public boolean Edit(Pessoa pessoa) throws Exception {
		try {
			String sqlEdit = "UPDATE Pessoa SET name = ?, email = ? WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sqlEdit);
			pstmt.setString(1, pessoa.getNome());
			pstmt.setString(2, pessoa.getEmail());
			pstmt.setInt(3, pessoa.getId());
			pstmt.execute();
			pstmt.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e);
		}finally {
			conn.close();
		}
	}
	
}
