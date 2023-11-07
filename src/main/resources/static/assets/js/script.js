document.getElementById('loginProcess').addEventListener('click', (evt) => {
    // evt.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    fetch('/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            'username': username,
            'password': password,
        })
    })
        .then(response => response.json())
        .then(value => {

            if (value.data === 'success') {
                localStorage.setItem('accessToken',value.accessToken)
                if (value.userRole === 'ADMIN'){
                    window.location.href = '/dashboard';
                }
            } else {
                document.getElementById('msg').innerHTML = value.data;
            }

        })
        .catch((error) => {
            console.log('Error', error);
        })
})


////
// var jwtToken = "your_jwt_token_here";
//
// $.ajax({
//     type: 'GET', // or 'POST', 'PUT', etc. depending on your server-side configuration
//     url: '/dashboard', // The endpoint you want to access
//     headers: {
//         'Authorization': 'Bearer ' + jwtToken, // Set the Authorization header with the token
//     },
//     success: function(data) {
//         // Handle the success response here
//     },
//     error: function(xhr, status, error) {
//         // Handle any errors here
//     }
// });


let sidebar = document.querySelector(".sidebar");
let sidebarBtn = document.querySelector(".sidebarBtn");
sidebarBtn.onclick = function () {
    sidebar.classList.toggle("active");
    if (sidebar.classList.contains("active")) {
        sidebarBtn.classList.replace("bx-menu", "bx-menu-alt-right");
    } else
        sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
}