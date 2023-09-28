package com.example.openai.data.response.textClassification

import com.google.gson.annotations.SerializedName

data class CategoryScores(
    val harassment: Double,

    @SerializedName("harassment/threatening")
    val harassmentThreatening: Double,

    val hate: Double,

    @SerializedName("hate/threatening")
    val hateThreatening: Double,

    val selfHarm: Double,

    @SerializedName("self-harm/instructions")
    val selfHarmInstructions: Double,

    @SerializedName("self-harm/intent")
    val selfHarmIntent: Double,

    val sexual: Double,

    @SerializedName("sexual/minors")
    val sexualMinors: Double,

    val violence: Double,

    @SerializedName("violence/graphic")
    val violenceGraphic: Double
)


