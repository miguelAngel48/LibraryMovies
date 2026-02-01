const loginBtn = document.getElementById("openLogin");
const registerBtn = document.getElementById("openRegister");

const loginModal = document.getElementById("loginModal");
const registerModal = document.getElementById("registerModal");

loginBtn.onclick = () => loginModal.style.display = "flex";
registerBtn.onclick = () => registerModal.style.display = "flex";

document.querySelectorAll(".close").forEach(btn => {
    btn.onclick = () => {
        document.getElementById(btn.dataset.close).style.display = "none";
    };
});

window.onclick = (e) => {
    if (e.target.classList.contains("modal")) {
        e.target.style.display = "none";
    }
};
