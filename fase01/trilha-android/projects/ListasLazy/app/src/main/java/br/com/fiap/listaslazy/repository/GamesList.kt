package br.com.fiap.listaslazy.repository

import br.com.fiap.listaslazy.model.Game

fun getAllGames(): List<Game> {
    return listOf(
        Game(id = 1, title = "Double Dragon", studio = "Technos", releaseYear = 1987),
        Game(id = 2, title = "Batletoads", studio = "Tradewest", releaseYear = 1991),
        Game(id = 3, title = "Enduro", studio = "Activision", releaseYear = 1983),
        Game(id = 4, title = "Ikari Warriors", studio = "SNK", releaseYear = 1986),
        Game(id = 5, title = "Captain Commando", studio = "Capcom", releaseYear = 1991),
        Game(id = 6, title = "Mario Bros", studio = "Nintendo", releaseYear = 1983),
        Game(id = 7, title = "Tiger Heli", studio = "Taito", releaseYear = 1985),
        Game(id = 8, title = "Mega Man", studio = "Capcom", releaseYear = 1987),
        Game(id = 9, title = "Gradius", studio = "Konami", releaseYear = 1985),
        Game(id = 10, title = "Gun Fight", studio = "Taito", releaseYear = 1975)
    )
}

fun getGamesByStudio(studio: String): List<Game>{
    return getAllGames().filter {
        it.studio.startsWith(prefix = studio, ignoreCase = true)
    }
}