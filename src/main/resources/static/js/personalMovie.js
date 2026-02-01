const searchers = document.querySelectorAll(".person-search");

searchers.forEach(input => {

    const hidden = input.nextElementSibling;

    const list = document.createElement("ul");
    list.classList.add("personSearch");
    list.style.display = "none";

    input.after(list);

    input.addEventListener("blur", () => {
        setTimeout(() => {
            list.style.display = "none";
        }, 150);
    });

    input.addEventListener("focus", () => {
        if (list.children.length > 0) {
            list.style.display = "block";
        }
    });

    input.addEventListener("input", async () => {

        const q = input.value.trim();

        if (q.length < 2) {
            list.style.display = "none";
            return;
        }

        const res = await fetch(`/api/autocomplete?query=${q}&type=PERSON`);
        const data = await res.json();

        list.innerHTML = "";
        list.style.display = "block";

        data.forEach(p => {
            const li = document.createElement("li");
            li.textContent = p.label;

            li.onclick = () => {
                input.value = p.label;
                hidden.value = p.id;
                list.style.display = "none";
            };

            list.appendChild(li);
        });
    });
});
