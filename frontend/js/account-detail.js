async function loadMemes() {
    await load()
    for(index = 0; index < 12 || index < notifications.length; index +=2) {
        document.getElementById("from".concat(index.toString())).innerText=notifications[index];
        document.getElementById("pic".concat((index+1).toString())).src=notifications[index+1];
    }
}

function load(){
    return new Promise((resolve,reject)=>{
        let urlExt = url.concat("/notifications/").concat(userEmail);
        axios.get(urlExt, headers).then((res) => {
            console.log(res)
            notifications = res.data.notifications;
        })
        setTimeout(()=>{
            resolve();
        ;} , 5000
        );
    });
}
function changeHoroscope(horoscope) {
    let urlExt = url.concat( "/horoscope/").concat(userEmail);
    let memeObj = {
        "horoscope": horoscope
    }
    axios.post(urlExt, memeObj, headers).then((res) => {console.log(res.data)})
}

