const suggestions = document.querySelector('#suggestions')
const search = document.querySelector('#search')
const poster = document.getElementById("poster")

const TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjYzc1ZmU4MmVjMWI4NWZmZmYwMWE5MTM3YmY5NTZmMSIsIm5iZiI6MTc2ODY3NzI5OS42MjYsInN1YiI6IjY5NmJkZmIzOWUwMjk1YzgwODhmYzE3NSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.S1XDjWTQ4-YLpnUfP_5AfmxsXLy6HDY4gi2IgrA2ejQ";



search.addEventListener('input', async () => {
    const q = search.value.trim();
    suggestions.innerHTML = ""

    if (q.length < 2) return;

    const res = await fetch(`/api/autocomplete?query=${q}`);

    if (!res.ok) {
        console.error("Error backend:", res.status);
        return;
    }
    const data = await res.json();
    suggestions.style.display = "block";

    data.forEach(title => {
        const li = document.createElement("li")
        li.textContent = title;
        li.onclick = () => {
            search.value = title;
            suggestions.innerHTML = "";
            suggestions.style.display = "none";
        };
        suggestions.appendChild(li);

    });
    search.addEventListener("blur", () => {
        setTimeout(() => {
            suggestions.style.display = "none";
        }, 150);
    });

})

