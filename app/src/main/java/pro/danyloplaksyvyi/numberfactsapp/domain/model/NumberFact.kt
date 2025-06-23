package pro.danyloplaksyvyi.numberfactsapp.domain.model

data class NumberFact(
    val id: Long = 0,
    val number: String,
    val fact: String,
    val timestamp: Long = System.currentTimeMillis(),
    val isRandom: Boolean = false
) {
    val factPreview: String
        get() = if (fact.length > 50) "${fact.take(50)}..." else fact
}