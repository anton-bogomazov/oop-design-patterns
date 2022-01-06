package structural

class LegacyCreator {

    fun createField(data: String) = "<div>$data</div>"

}

class ModernCreator {

    fun createField(data: Data, tagType: TagType) = Field(tagType, data)

}

data class Data(var data: String)
enum class TagType { H1, H2, DIV }
data class Field(var tagType: TagType, var data: Data)

// Application is working with LegacyCreator,
// but now we want to use a new framework with ModernCreator and
// don't want to rewrite all calls to LegacyCreator

class FieldCreatorAdapter(
    private val creator: ModernCreator
) {

    fun createField(data: String): String {
        val field = creator.createField(Data(data), TagType.DIV)
        val tagName = field.tagType.name.lowercase()

        return "<$tagName>${field.data.data}</$tagName>"
    }

}