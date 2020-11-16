package travelator

data class EmailAddress(
    val localPart: String,
    val domain: String
) {

    override fun toString() = "$localPart@$domain"

    companion object {
        @JvmStatic
        fun parse(value: String): EmailAddress {
            val atIndex = value.lastIndexOf('@')
            atIndex.let {
                require(!(atIndex < 1 || atIndex == value.length - 1)) {
                    "EmailAddress must be two parts separated by @"
                }
                return EmailAddress(
                    value.substring(0, atIndex),
                    value.substring(atIndex + 1)
                )
            }
        }
    }
}