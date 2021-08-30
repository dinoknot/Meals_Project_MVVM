package com.diegoribeiro.mealsproject.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.diegoribeiro.mealsproject.data.model.Category
import com.diegoribeiro.mealsproject.utils.constants.Constants.CATEGORIES_TABLE

@Entity(tableName = CATEGORIES_TABLE)
class CategoriesEntity(
    var category: Category
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}