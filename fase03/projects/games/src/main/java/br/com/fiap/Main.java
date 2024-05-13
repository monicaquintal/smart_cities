//package br.com.fiap;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import br.com.fiap.dao.GameDao;
//import br.com.fiap.model.Game;
//import br.com.fiap.utils.Conexao;
//import jakarta.persistence.EntityManager;
//
//public class Main {
//
//	public static void main(String[] args) {
//		
////		Game game1 = new Game();
////		game1.setId(4L);;
////		game1.setTitulo("Batletoads");
////		game1.setCategoria("Luta");
////		// game1.setDataLancamento(LocalDate.of(1992, 8, 1));
////		game1.setDataLancamento(LocalDate.of(1991, 6, 1));
////		game1.setFinalizado(true);
////		// game1.setProdutora("Tradewest");
////		game1.setProdutora("Tradewest, Rare");
////		game1.setValor(99.89);
////		
////		EntityManager em = Conexao.getEntityManager();
////		GameDao gameDao = new GameDao(em);
////		
////		em.getTransaction().begin();
////		// gameDao.salvar(game1);
////		// gameDao.atualizar(game1);
////		gameDao.remover(game1);
////		em.getTransaction().commit();
////		em.close();
//		
//		EntityManager em = Conexao.getEntityManager();
//		// cadastrar(em);
//		// pesquisar(em);
//		// listarTodosOsGames(em);
//		// buscarGamePeloNome(em);
//		buscarGamesPorFaixaDeValores(em);
//		
//		em.close();
//		
//	}
//	
//	public static void buscarGamesPorFaixaDeValores(EntityManager em) {
//		GameDao gameDao = new GameDao(em);
//		List<Game> games = gameDao.buscarGamesPorFaixaDeValores(150.0, 300.0);
//		
//		for (Game game : games) {
//			System.out.println(game);
//			System.out.println("------------------------");
//		}
//	}
//	
//	public static void buscarGamePeloNome(EntityManager em) {
//		GameDao gameDao = new GameDao(em);
//		List<Game> games = gameDao.buscarGamePeloNome("mega man 2".toUpperCase());
//		
//		for (Game game : games) {
//			System.out.println(game);
//			System.out.println("------------------------");
//		}
//	}
//	
//	public static void listarTodosOsGames(EntityManager em) {
//		GameDao gameDao = new GameDao(em);
//		List<Game> games = gameDao.listarTodosOsGames();
//		
//		for (Game game : games) {
//			System.out.println(game);
//			System.out.println("------------------------");
//		}
//	}
//
//	public static void pesquisar (EntityManager em) {
//		
//		GameDao gameDao = new GameDao(em);
//		Game game = new Game();
//		game.setId(3L);
//		Game gameEncontrado = gameDao.buscarGamePeloId(game);
//		
//		if (gameEncontrado != null) {
//			System.out.println(gameEncontrado.toString());
//		} else {
//			System.out.println("Game não encontrado!");
//		}
//	}
//	
//	public static void cadastrar (EntityManager em) {
//		Game game1 = new Game();
//		game1.setTitulo("Ikari Warriors");
//		game1.setCategoria("Arcade");
//		game1.setDataLancamento(LocalDate.of(1986, 1, 1));
//		game1.setFinalizado(true);
//		game1.setProdutora("SNK");
//		game1.setValor(256.88);
//		
//		GameDao gameDao = new GameDao(em);
//		
//		em.getTransaction().begin();
//		gameDao.salvar(game1);
//		game1.setTitulo("Ikari Warriors SNK");
//		em.getTransaction().commit();
//	}
//}

// ------------------------------------------

// package br.com.fiap;

// import java.time.LocalDate;

//import br.com.fiap.dao.GameDao;
//import br.com.fiap.model.Game;
//import br.com.fiap.utils.Conexao;
//import jakarta.persistence.EntityManager;

//public class Main {
//
//	public static void main(String[] args) {
//		
//		Game game1 = new Game();
//		game1.setTitulo("Street Fighter II");
//		game1.setCategoria("Luta");
//		game1.setDataLancamento(LocalDate.of(1991, 6, 1));
//		game1.setFinalizado(true);
//		game1.setProdutora("Capcom");
//		game1.setValor(99.89);
//		
//		EntityManager em = Conexao.getEntityManager();
//		GameDao gameDao = new GameDao(em);
//		
//		em.getTransaction().begin();
//        gameDao.salvar(game1);
//		em.getTransaction().commit();
//		em.close();
//		
//	}
//
//}

// ---------------------------------------

//package br.com.fiap;
//
//import java.time.LocalDate;
//
//import br.com.fiap.dao.GameDao;
//import br.com.fiap.model.Game;
//import br.com.fiap.utils.Conexao;
//import jakarta.persistence.EntityManager;
//
//public class Main {
//
//	public static void main(String[] args) {
//		
//		Game game1 = new Game();
//		game1.setTitulo("Ikari Warriors");
//		game1.setCategoria("Arcade");
//		game1.setDataLancamento(LocalDate.of(1986, 1, 1));
//		game1.setFinalizado(true);
//		game1.setProdutora("SNK");
//		game1.setValor(256.88);
//		
//		EntityManager em = Conexao.getEntityManager();
//		GameDao gameDao = new GameDao(em);
//		
//		em.getTransaction().begin();
//		gameDao.salvar(game1);
//      game1.setTitulo("Ikari Warriors SNK");
//		em.getTransaction().commit();
//		
//		em.close();
//		
//	}
//	
//	
//
//}

package br.com.fiap;

import br.com.fiap.dao.CategoriaDao;
import br.com.fiap.dao.GameDao;
import br.com.fiap.model.Categoria;
import br.com.fiap.model.Game;
import br.com.fiap.utils.Conexao;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManager em = Conexao.getEntityManager();

        //cadastrar(em);
        //pesquisar(em);
        //listarTodosOsGames(em);
        //buscarGamePeloNome(em);
        //buscarGamesPorFaixaDeValores(em);
        buscarCategoriaPeloId(em);

        em.close();

    }

    public static void buscarCategoriaPeloId(EntityManager em) {
        CategoriaDao gameDao = new CategoriaDao(em);
        Categoria categoria = new Categoria();
        categoria.setId(2L);
        Categoria categoriaEncontrada = gameDao.buscarCategoriaPeloId(categoria);
        System.out.println(categoriaEncontrada.toString());
    }
	
	public static void cadastrar(EntityManager em) {
	    // Criamos uma categoria
	    Categoria luta = new Categoria();
	    //luta.setNomeCategoria("LUTA");
	    luta.setId(1L);

	    // Criamos uma instância de CategoriaDao
	    // CategoriaDao categoriaDao = new CategoriaDao(em);

	    // Iniciamos uma transação de dados no banco
	    em.getTransaction().begin();

	    // Chamamos o método salvar de CategoriaDao
	    // para persistir uma categoria no banco
	    // categoriaDao.salvar(luta);

	    // Criamos um game da categoria luta
	    Game game1 = new Game();
	    game1.setTitulo("Street Fighter II");
	    game1.setCategoria(luta);
	    game1.setDataLancamento(LocalDate.of(1992, 2, 1));
	    game1.setFinalizado(true);
	    game1.setProdutora("Capcom");
	    game1.setValor(399.99);

	    // Criação de uma instância de GameDao
	    GameDao gameDao = new GameDao(em);

	    // Chamamos o método salvar de GameDao
	    // para persistir um game no banco
	    gameDao.salvar(game1);

	    // Efetuamos o commit para sincronizar
	    // no banco de dados todas as alterações
	    em.getTransaction().commit();

	    // Fechamos a EntityManager
	    em.close();
	}
	
	public static void listarTodosOsGames(EntityManager em) {
	GameDao gameDao = new GameDao(em);
	List<Game> games = gameDao.listarTodosOsGames();
	
	for (Game game : games) {
		System.out.println(game);
		System.out.println("------------------------");
		}
	}

	public static void pesquisar (EntityManager em) {
		
		GameDao gameDao = new GameDao(em);
		Game game = new Game();
		game.setId(12L);
		Game gameEncontrado = gameDao.buscarGamePeloId(game);
		
		if (gameEncontrado != null) {
			System.out.println(gameEncontrado.toString());
		} else {
			System.out.println("Game não encontrado!");
		}
	}
}