//Este archivo se encarga de manejar la lógica de la interfaz de usuario para gestionar productos o sea de conectar con el backend y actualizar la vista en consecuencia.

const API_URL = "/api/products";

document.addEventListener("DOMContentLoaded", () => {
    loadProducts();

    const form = document.getElementById("productForm");
    form.addEventListener("submit", async (e) => {
        e.preventDefault();

        const product = {
            name: document.getElementById("name").value,
            price: parseFloat(document.getElementById("price").value),
            stock: parseInt(document.getElementById("stock").value),
        };

        await fetch(API_URL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(product),
        });

        form.reset();
        loadProducts();
    });
});

async function loadProducts() {
    const res = await fetch(API_URL);
    const products = await res.json();

    const tbody = document.querySelector("#productsTable tbody");
    tbody.innerHTML = "";

    products.forEach((p) => {
        const row = `
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.price}</td>
                <td>${p.stock}</td>
                <td>
                    <button class="btn btn-danger btn-sm" onclick="deleteProduct(${p.id})">Eliminar</button>
                </td>
            </tr>
        `;
        tbody.innerHTML += row;
    });
}

async function deleteProduct(id) {
    await fetch(`${API_URL}/${id}`, { method: "DELETE" });
    loadProducts();
}
