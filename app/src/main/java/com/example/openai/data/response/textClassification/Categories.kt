package com.example.openai.data.response.textClassification

import com.google.gson.annotations.SerializedName

data class Categories(
    @SerializedName("harassment")
    val  harassment : Boolean,
    @SerializedName("harassment/threatening")
    val harassmentNndThreatening: Boolean,
    @SerializedName("hate")
    val hate: Boolean,
    @SerializedName("hate/threatening")
    val hateANDThreatening: Boolean,
    @SerializedName("self-harm")
    val self_harm: Boolean,
    @SerializedName("self-harm/instructions")
    val self_harm_instructions: Boolean,
    @SerializedName("self-harm/intent")
    val self_harm_intent: Boolean,
    @SerializedName("sexual")
    val sexual: Boolean,
    @SerializedName("sexual/minors")
    val sexual_minors: Boolean,
    @SerializedName("violence")
    val violence: Boolean,
    @SerializedName("violence/graphic")
    val violence_graphic: Boolean
)