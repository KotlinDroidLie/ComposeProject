package com.practicum.composeproject

data class Contact(
    val name: String,
    val surname: String? = null,
    val familyName: String,
    val imageRes: Int? = null,
    val isFavorite: Boolean = false,
    val phone: String,
    val address: String,
    val email: String? = null,
)



val frogContact = Contact(
    name = "Лягушка",
    familyName = "Прудовая",
    imageRes = R.drawable.frog,
    phone = "+7 (496) 770-71-45",
    address = "Московская обл., г.о. Серпухов, местечко Данки, д. 25",
)

val pushkinContact = Contact(
    name = "Александр",
    surname = "Сергеевич",
    familyName = "Пушкин",
    imageRes = null,
    isFavorite = true,
    phone = "+7 (812) 314-18-37",
    address = "г. Санкт-Петербург, наб. реки Мойки, д. 12",
    email = "pushkin@example.ru"
)