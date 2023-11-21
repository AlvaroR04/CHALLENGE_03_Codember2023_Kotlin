import java.io.File
import java.util.Scanner

fun main() {
    val invalida = 42 //Clave inválida donde se detendrá el bucle
    var numInvalidas = 0 //Cantidad de claves inválidas
    var claveInvalida = "" //Aquí se guardará la clave inválida
    val lector = Scanner(File("encryption_policies.txt"))

    while(lector.hasNext() && numInvalidas < invalida) {
        val clave = lector.nextLine().split(' ')
        var min = 0
        var max = 0
        val letra = clave[1].first() //Obtener la letra
        var apariciones = 0

        var tmpNum = ""
        clave[0].forEach { //Obtener el minimo y maximo especificado
            if(it.isDigit()) {
                tmpNum += it
            } else if(it == '-') {
                min = tmpNum.toInt()
            }
        }
        max = tmpNum.toInt()

        clave[2].forEach { //Contar las apariciones de la letra en la clave
            if(it == letra) {
                apariciones++
            }
        }

        if(apariciones < min || apariciones > max) { //En caso de que este fuera de limites
            numInvalidas++
            claveInvalida = clave[2]
        }
    }

    println(claveInvalida)
}