let currentPage = 0;
let extra = memelikedlist.length % 8
let amountOfPages = memelikedlist.length / 8 - 1;
async function loadMemes() {
    await load()
    console.log(memelikedlist);
    for (let index = 1; index <= 8; index++) {
        document.getElementById("pic".concat(index.toString())).src=memelikedlist[index-1];
    }
}

function load(){
    return new Promise((resolve,reject)=>{
        let urlExt = url.concat("/memelikedlist/").concat(userEmail);
        axios.get(urlExt, headers).then((res) => {
            console.log(res)
            memelikedlist = res.data.memeLikedList;
        })
        setTimeout(()=>{
            resolve();
        ;} , 5000
        );
    });
}


function next8() {
    currentPage ++
    if (currentPage <= amountOfPages) { 
        for (let index = 0; index < 8; index++) {
            document.getElementById("pic".concat(index.toString())).src=memelikedlist[index+(currentPage*8)];
        }
    } else if (currentPage <= amountOfPages + 1){
        for (let index = 0; index < 8; index++) {
            document.getElementById("pic".concat(index.toString())).src=memelikedlist[index+(currentPage*8)];
            if(index >= extra) {
                document.getElementById("pic".concat(index.toString())).src="";
            }
        }
    } else {
        currentPage--
    }
}
function previous8() {
    currentPage --
    if (currentPage >= 0) { 
        for (let index = 0; index < 8; index++) {
            document.getElementById("pic".concat(index.toString())).src=memelikedlist[index+(currentPage*8)];
        }
    } else {
        currentPage++
    }
}

