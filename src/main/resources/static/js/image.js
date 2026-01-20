const titleEl = document.querySelectorAll('.title');


for (let i = 0; i < titleEl.length; i++) {
    if (titleEl && poster) {
        const title = titleEl[i].innerText.trim();

        fetch(
            `https://api.themoviedb.org/3/search/movie?query=${encodeURIComponent(title)}&language=es-ES`,
            {
                method: "GET",
                headers: {
                    Authorization: `Bearer ${TOKEN}`,
                    Accept: "application/json"
                }
            }
        )
            .then(res => res.json())
            .then(data => {

                if (!data.results || data.results.length === 0) return;
                const movie = data.results[0];
                if (!movie.poster_path) return;
                poster[i].src = `https://image.tmdb.org/t/p/w500${movie.poster_path}`;
                poster[i].style.display = "block";

            });
    }

}
