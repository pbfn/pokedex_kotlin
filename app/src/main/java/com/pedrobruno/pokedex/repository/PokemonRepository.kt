package com.pedrobruno.pokedex.repository

import com.pedrobruno.pokedex.data.remote.PokeApi
import com.pedrobruno.pokedex.data.remote.responses.Pokemon
import com.pedrobruno.pokedex.data.remote.responses.PokemonList
import com.pedrobruno.pokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemnList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("Ocorreu um erro")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName:String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("Ocorreu um erro")
        }
        return Resource.Success(response)
    }

}