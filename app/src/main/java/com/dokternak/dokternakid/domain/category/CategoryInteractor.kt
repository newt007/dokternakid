package com.dokternak.dokternakid.domain.category

import com.dokternak.dokternakid.data.category.CategoryRepository
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.category.model.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class CategoryInteractor(
    private val repository: CategoryRepository
): CategoryUseCase {

    override fun getAllCategories(): Flow<ApiResponse<List<Category>>> {
        return repository.getAllCategories()
            .flowOn(Dispatchers.IO)
    }

}