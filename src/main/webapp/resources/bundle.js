'use strict'

var NUMBER_MAILS = 0

const getCountMails = () => {
    return document.getElementsByClassName("textMail").length;
}

const removeEmail = (id) => {
    let element = document.getElementById("boxMail" + id)
    element.remove();
    reIndex();
}

const reIndex = () => {
    document.querySelectorAll(".txt-mail")
        .forEach((element, index) => {
            element.innerText = "Correo " + (index + 1)
        });
}

var main = () => {
    console.log("get ready!")

    const btnAdd = document.getElementById("add")
    btnAdd.addEventListener("click", () => {
        let numberMails = getCountMails()
        if (numberMails < 4) {
            let mailBox = document.createElement("div"),
                lblMail = document.createElement("label"),
                txtMail = document.createElement("span"),
                inputMail = document.createElement("input"),
                btnRemove = document.createElement("button"),
                idel = document.createElement("i"),
                seccion = document.getElementById("mails")

            NUMBER_MAILS += 1

            mailBox.setAttribute("id", "boxMail" + NUMBER_MAILS)

            txtMail.innerText = "Correo " + (numberMails + 1)
            txtMail.setAttribute("class", "txt-mail")

            inputMail.setAttribute("type", "email")
            inputMail.setAttribute("name", "mails")
            inputMail.setAttribute("id", "mail"+ NUMBER_MAILS)
            inputMail.setAttribute("class", "textMail")
            inputMail.setAttribute("REQUIRED", true)

            btnRemove.setAttribute("type", "button")
            btnRemove.setAttribute("name", "mailRemove")
            btnRemove.value = NUMBER_MAILS


            idel.setAttribute("class", "fa fa-eraser")
            btnRemove.addEventListener("click", () => { removeEmail(btnRemove.value) }, false )
            btnRemove.appendChild(idel)

            lblMail.appendChild(txtMail)
            lblMail.appendChild(inputMail)
            lblMail.appendChild(btnRemove)

            mailBox.appendChild(lblMail)

            seccion.appendChild(mailBox)

            reIndex()

        } else {
            alert('No se pueden agregar mas correos')
        }

    },
    false);
}

window.onload = () => {

    main()

}