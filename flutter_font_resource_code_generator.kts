/****
 *
 * ### font code for yaml file + font static reference in dart code ######
 * copy paste font path using IDE
 * select all font file -> right click -> copy path -> copy path from repo root -> paste below
 * #### place font section inside flutter section in yaml file
 *
 *
 * */

val s = """
fonts/museo_sans_100.ttf
fonts/museo_sans_300.ttf
fonts/museo_sans_500.ttf
fonts/museo_sans_500_italic.ttf
fonts/museo_sans_700.ttf
fonts/museo_sans_cyrl_100_ital.ttf
fonts/museo_sans_cyrl_300_ital.ttf
fonts/museo_sans_cyrl_700_ital.ttf
fonts/museo_sans_cyrl_900.ttf
fonts/museo_sans_cyrl_900_ital.ttf
fonts/tajawal_bold.ttf
fonts/tajawal_extra_bold.ttf
fonts/tajawal_extra_light.ttf
fonts/tajawal_light.ttf
fonts/tajawal_medium.ttf
fonts/tajawal_regular.ttf
fonts/tajawala_black.ttf
""".trimIndent()




fun namify(string: String): String {
    return string.split(".")[0]
        .replace(" ", "_")
        .replace("-", "_")
        .replace("_____", "_")
        .replace("____", "_")
        .replace("___", "_")
        .replace("__", "_")
}


fun getFontScriptForYamlFile(fileName: String, displayname: String): String {
    return "    - family: $displayname\n"+
            "      fonts:\n"+
            "        - asset: $fileName\n\n"

}





println("  fonts:\n"+s.split("\n").map {
    val fileName = it.trimIndent()
    val displayname = namify(fileName.split("/").last())
    getFontScriptForYamlFile(fileName, displayname)
}.joinToString(""))






println("\n\n\n\n")

println("class MyFont {\n" +
        s.split("\n").map {
            val fileName = it.trimIndent()
            val displayname = namify(fileName.split("/").last())
            "  static const String $displayname = '$displayname';\n"
        }.joinToString("")
        +
        "\n" +
        "}\n")




