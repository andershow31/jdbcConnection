package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
 //temos que carregar as propriedades do bd.properties
	//carregamos por meio de um objeto Properties dentro desta classe
	//abaixo o código carrega as propriedades por meio de uma variável estática
	//pois será apenas usada nesta classe, carregamos o arquivo a partir de uma stream, e como se trata de arquivo
	//temos que tratar as exceções
	//FileInputStream é uma classe do pacote java.io usada para ler dados de arquivos no formato de fluxo de bytes.
	// ele é geralmente utilizado para leitura de arquivos binários, como imagens, áudios e documentos,
	//mas também pode ser usado para ler arquivos de texto.

	private static Connection conn = null;
	public static Connection getConnection() {
		//o objeto Connection é o que faz com que conecte ao banco
		//para a conexão devemos instanciar um obj Connection
		if(conn == null) {
			//outra questão a verificar é que usando a exceção personalizada
			//evitamos a necessidade de usar muitos try's no programa principal
			
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			
				}catch(SQLException e) {
					throw new DbException(e.getMessage());
				}
			}
		return conn;
	}
	public static void closeConnection() {
		if(conn != null) {
			try{
			conn.close();
			}catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	private static Properties loadProperties() { // o static faz com que somente esta classe possa usar
		try (FileInputStream fs = new FileInputStream("//bd.properties")){
			Properties props = new Properties();
			props.load(fs);//o load carrega o arquivo
			return props;
		}catch(IOException e) {
			throw new DbException(e.getMessage());
		}
	}
		
	
}
