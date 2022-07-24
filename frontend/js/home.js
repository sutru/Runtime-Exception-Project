let currIndex = 0;
let direction = 0; 
function next() {
    document.getElementById("horo").innerText=""
    let urlExt = url.concat("/memetable/").concat((currIndex+1).toString())
    let success = false;
    if (currIndex >= 98) {
        currIndex = 0
    }
    axios.get(urlExt, headers).then((res) => {
                document.getElementById("image1").src=res.data.memeModel.url
                success = true
                console.log(res)
            });
    
    currIndex++
    direction = 1;
}
function previous() {
    document.getElementById("horo").innerText=""
    let urlExt = url.concat("/").concat((currIndex-1).toString())
    if (currIndex <= 0) {
        currIndex = 97
    }
    axios.get(urlExt, headers).then((res) => {
        document.getElementById("image1").src=res.data.memeModel.url
        currIndex-=1;
    });
    direction = -1;
}

function random() {
    document.getElementById("horo").innerText=""
    let urlExt = url.concat("/memetable/")
    axios.get(urlExt, headers).then((res) => {
        document.getElementById("image1").src=res.data.memeModel.url
        currIndex = res.data.memeModel.numInDb
        console.log(res)
    });
    direction = 0;
}
function save() {
    let urlExt = url.concat( "/memelikedlist/addmeme");
    let memeObj = {
        "email": "asadasdsa@gmail.com",
        "url": document.getElementById("image1").src
    }
    axios.post(urlExt, memeObj, headers).then((res) => {console.log(res.data)})
}
function share() {
    let fromEmail = prompt("Who do you want to send this meme to", "");
    if (fromEmail != null) {
        let urlExt = url.concat( "/notifications/").concat(userEmail);
        let memeObj = {
            "fromEmail": fromEmail,
            "url": document.getElementById("image1").src
        }
        axios.post(urlExt, memeObj, headers).then((res) => {console.log(res.data)})
    }
}
function horoscope() {
    userEmail = sessionStorage.getItem("userEmail")
    document.getElementById("horo").innerText="DAILY HOROSCOPE"
    let urlExt = url.concat("/horoscope/").concat(userEmail)
    showSpinner()
    axios.get(urlExt, headers).then((res) => {
        if (res.data.url != "no horo") {
            document.getElementById("image1").src=res.data.url
        }else {
            random()
        }
        hideSpinner()
    });
    
    currIndex = 1;
}
function showSpinner() {
    document.getElementById('spinner').style.display="block"
}
function hideSpinner() {
    document.getElementById('spinner').style.display="none"
    
}

function handleError() {
   if (direction < 0) {
       previous()
   } else if (direction > 0) {
       next()
   } else {
       random()
   }
}
