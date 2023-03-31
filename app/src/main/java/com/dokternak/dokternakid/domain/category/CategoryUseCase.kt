package com.dokternak.dokternakid.domain.category

import com.dokternak.dokternakid.data.lib.ApiResponse
import com.dokternak.dokternakid.domain.category.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryUseCase {

    fun getAllCategories(): Flow<ApiResponse<List<Category>>>

}