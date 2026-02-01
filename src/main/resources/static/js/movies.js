const suggestions = document.querySelector('#suggestions')
const search = document.querySelector('#search')
const formId = document.querySelector('formsId')
const formatSuggestion = document.getElementById('typeForm')
const typeFormat = document.getElementById('searchType')





search.addEventListener('input', async () => {
    const q = search.value.trim();
    suggestions.innerHTML = ""

    if (q.length < 2) return;

    const res = await fetch(`/api/autocomplete?query=${q}&type=${typeFormat.value}`);
    if (!res.ok) {
        console.error("Error backend:", res.status);
        return;
    }
    const data = await res.json();
    const resultString = JSON.stringify(data);
    const movie = JSON.parse(resultString);
    suggestions.style.display = "block";

    movie.forEach(movie => {

        const li = document.createElement("li")
        li.textContent = movie.label;
        li.onclick = () => {
            window.location.href = `/${formatSuggestion.value}?id=${movie.id}`;
            search.value = movie.label;
            suggestions.innerHTML = "";
            formId.value = movie.id

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
