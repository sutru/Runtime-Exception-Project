let userEmail = "asadasdsa@gmail.com";
let memelikedlist = ['https://i.redd.it/se34mmieg1p21.png', 'https://i.kym-cdn.com/photos/images/original/002/186/254/918.png', 'https://pm1.narvii.com/7409/c2f3a2844aecdddcf88609641704a8f4e5c4db6er1-1242-1205v2_hq.jpg', 'https://pics.me.me/thumb_will-felix-understand-this-found-on-r-memes-72397282.png', 'https://camo.githubusercontent.com/958c1817e60bc0e…f2f692e696d6775722e636f6d2f58764b685a5a632e706e67', 'https://i.imgflip.com/4gyg4d.jpg', 'https://assets.change.org/photos/2/ld/jw/aslDJwQkHyAxQZf-800x450-noPad.jpg?1547492683', 'https://i.kym-cdn.com/photos/images/original/002/273/220/949.jpg', 'https://pbs.twimg.com/profile_images/932954186278428672/67uSz6gN_400x400.jpg', 'https://78.media.tumblr.com/1e446f3f2f39097c9947a912fdfc5fd3/tumblr_pvz9yfD2Qy1uy57v5o1_1280.jpg', 'https://res.cloudinary.com/teepublic/image/private…_630/v1547962715/production/designs/4040559_0.jpg', 'https://images.wondershare.com/filmora/article-images/MemeEconomy.JPG', 'http://images7.memedroid.com/images/UPLOADED393/612f609954577.jpeg', 'https://i.pinimg.com/originals/48/20/33/4820333ce263aa7ffd98bf17771a7b0b.jpg', 'https://ih1.redbubble.net/image.1278645880.9388/gbra,6x4,1000x1000-c,0,0,675,900.jpg', 'https://i.ytimg.com/vi/a2ULPD62LoI/mqdefault.jpg', 'https://preview.redd.it/f99xkbueewl81.jpg?width=64…o=webp&s=f2eda35a5501e3e8f101d6dc4d361a42e3a285a0', 'https://i.redd.it/jamldlj946k21.jpg', 'https://i.kym-cdn.com/photos/images/original/002/208/797/9dd.jpg', 'https://pics.onsizzle.com/huffingtonpost-co-uk-som…saws-at-the-us-mexico-border-so-kids-67702100.png'];
let url = "https://g4yv4i4tg4.execute-api.us-west-2.amazonaws.com/prod";
let notifications = ["email@email.com","https://i.kym-cdn.com/photos/images/original/002/186/254/918.png","andrew@gmail.com","https://i.redd.it/se34mmieg1p21.png","testEmail","https://i.redd.it/se34mmieg1p21.png"]
let headers = {
    authorization: {
      'x-api-key': 'FyWu0VPqWuanyt47uz7fD3SmmCBZLRHC6Xg08JLg'
    }
  }
function toHome(){
    window.location.replace("http://127.0.0.1:5501/home.html#");
}
function toSaved(){
    window.location.replace("http://127.0.0.1:5501/saved.html#");
}
function toHomeSaved(){
    window.location.replace("http://127.0.0.1:5501/homeSaved.html#");
}
function toAccountDetails(){
    window.location.replace("http://127.0.0.1:5501/account-details.html#");
}