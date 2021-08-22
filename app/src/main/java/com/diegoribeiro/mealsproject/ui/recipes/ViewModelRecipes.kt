package com.diegoribeiro.mealsproject.ui.recipes

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegoribeiro.mealsproject.data.model.Ingredient
import com.diegoribeiro.mealsproject.data.model.Meal
import com.diegoribeiro.mealsproject.data.model.Meals
import com.diegoribeiro.mealsproject.data.model.Recipes
import com.diegoribeiro.mealsproject.data.remote.ResourceNetwork
import com.diegoribeiro.mealsproject.data.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewModelRecipes: ViewModel() {
    private var repository = Repository
    val mealById: MutableLiveData<Recipes> = MutableLiveData()
    val ingredient: MutableLiveData<List<Ingredient>> = MutableLiveData()
    //private var mealResponse: Meal? = null

    init{
        mealById
    }

    fun getMealById(id: String){
        viewModelScope.launch {
            repository.getMealById(id).let { recipes ->
                mealById.postValue(recipes)
                ingredient.postValue(recipes.meals[0].filterBlankIngredient())
                Log.d("**ViewModel", recipes.meals[0].filterBlankIngredient().toString())
            }
        }
    }


//    private fun handleResponse(response: Response<Meal>): Meal{
//        if (response.isSuccessful){
//            response.body()?.let { resultResponse->
//                if (mealResponse == null){
//                    mealResponse = resultResponse
//                }
//                return ResourceNetwork.Success(mealResponse ?: resultResponse)
//            }
//        }
//        return ResourceNetwork.Error(response.message())
//    }



}