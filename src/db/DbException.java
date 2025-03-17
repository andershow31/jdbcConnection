package db;

public class DbException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	//eclipse pede para implementar
	
	public DbException(String msg) {
		super(msg); //envia a variável para mensagem na classe mãe
	}//é uma exceção personalizada
}
