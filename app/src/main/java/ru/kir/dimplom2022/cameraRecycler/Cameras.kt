package ru.kir.dimplom2022.cameraRecycler

object Cameras {

    private val value = listOf(
        createCamera("162.0.0.103", 1),
        createCamera("162.0.0.104", 2),
        createCamera("162.0.10.100", 3),
        createCamera("162.0.10.113", 4),
        createCamera("168.9.0.110", 5),
        createCamera("168.10.0.10", 6),
        createCamera("162.8.0.102", 7),
        createCamera("162.8.0.103", 8),
        createCamera("162.8.10.100", 9),
        createCamera("162.8.10.113", 10),
        createCamera("168.8.0.110", 5),
        createCamera("168.8.0.10", 6),
    )

    fun values() = value.mapIndexed { index: Int, camera: Camera ->
        val number = index + 1
        val location = when (index) {
            in 0..8 -> "Подъезд №$number"
            in 9..10 -> "Стоянка №$number"
            else -> "Двор. Камера №$number"
        }

        camera.copy(
            number = number,
            location = location
        )
    }

    private fun createCamera(ip: String, number: Int = 0): Camera {
        return Camera(ip, number)
    }
}