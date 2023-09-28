package com.example.openai.data.mapper

import android.util.Log
import com.example.openai.data.response.textClassification.ModerationResponse
import com.example.openai.domain.model.TextClassification

object ToTextClassificationMapper : Mapper<ModerationResponse, List<TextClassification>> {
    override fun map(input: ModerationResponse): List<TextClassification> {
        val categoryScores = input.results[0].categories


        return arrayListOf(
            TextClassification("Harassment", categoryScores.harassment),
            TextClassification("Hate", categoryScores.hate),
            TextClassification("Violence", categoryScores.violence),
            TextClassification("SelfHarm", categoryScores.self_harm),
            TextClassification("Sexual", categoryScores.sexual)
        )


    }
}
