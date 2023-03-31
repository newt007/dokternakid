package com.dokternak.dokternakid.data.category

import com.dokternak.dokternakid.data.category.remote.CategoryService
import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.category.mapper.toDomain
import com.dokternak.dokternakid.domain.category.model.Category
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CategoryDataStore(
    private val service: CategoryService
): CategoryRepository {

    override fun getAllCategories(): Flow<ApiResponse<List<Category>>> = flow {
        try {
            emit(ApiResponse.Loading)

            val response = service.getAnimalCategory()
            response.data?.let { result ->
                if (result.isNotEmpty()) {
                    emit(ApiResponse.Success(result.toDomain()))
                } else {
                    emit(ApiResponse.Empty)
                }
            }
        } catch (ex: Exception) {
            emit(ApiResponse.Error(ex.message.toString()))
        }
    }

}