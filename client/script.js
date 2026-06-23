async function shortenUrl(){
    const url=document.getElementById("url").value;

    const response = await fetch(
        "http://localhost:8080/add",
        {
            method:"POST",
            headers:{
                "Content-Type":"application/json"
            },
            body: JSON.stringify(
                {url:url}
            )
        }
    );
    const data = await response.json();
    console.log(data);
    const shorturl=`http://127.0.0.1:5500/client/${data.shortCode}`;
    
    document.getElementById("short-url").href=shorturl;
    document.getElementById("short-url").innerText=shorturl;
    document.getElementById("result-card").classList.remove("hidden");
    document.getElementById("copy-btn").onclick=async()=>{
        navigator.clipboard.writeText(shorturl);
    };

}
async function handleRedirect() {

const path =
    window.location.pathname;

const shortCode =
    path.split("/").pop();
    console.log(shortCode);

if ( shortCode &&shortCode!=="client") {

    const response =
        await fetch(
            `http://localhost:8080/${shortCode}`
        );
        console.log(response);
    const originalUrl=await response.text();
    console.log(originalUrl);

    // window.location.href=`originalUrl;
}

}

handleRedirect();