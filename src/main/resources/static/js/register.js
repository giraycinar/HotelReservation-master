
function register(){
       
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    let rePassword = document.getElementById('rePassword').value;
    let email = document.getElementById('email').value;

    
    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
    "email": email,
    "username": username,
    "password": password,
    "rePassword": rePassword
    });

    const requestOptions = {
    method: "POST",
    headers: myHeaders,
    body: raw,
    redirect: "follow"
    };
    /**
     * burcuAuthRegister +
     * enesAuthRegister +
     * mustafaAuthRegister +
     * yaseminAuthRegister +
     * girayAuthRegister
     */
    fetch(girayAuthRegister, requestOptions)
    .then((response) => response.json())
    .then((result) => console.log(result));
}
