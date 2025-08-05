document.addEventListener('DOMContentLoaded', () => {

    const API_URL = 'http://localhost:8080/api/products';
    const productSection = document.getElementById('productSection');

    const prevArrow = document.querySelector('.prev-arrow');
    const nextArrow = document.querySelector('.next-arrow');

    const formatPrice = (priceInCents) => {
        const priceInReais = priceInCents / 100;
        return priceInReais.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });
    };

    const createProductCard = (product) => {
        const cardDiv = document.createElement('div');
        cardDiv.className = 'card';
        cardDiv.dataset.productId = product.id;

        cardDiv.innerHTML = `
            <img src="${product.imageUrl}" alt="${product.name}">
            <h2>${product.name}</h2>
            <p>${formatPrice(product.priceInCents)}</p>
            <button class="add-to-cart-btn">Adicionar ao Carrinho</button>
        `;
        return cardDiv;
    };

    const fetchAndRenderProducts = async () => {
        try {
            const response = await fetch(API_URL);

            if (!response.ok) {
                throw new Error(`Erro de rede: ${response.status}`);
            }

            const products = await response.json();
            productSection.innerHTML = '';

            products.forEach(product => {
                const productCard = createProductCard(product);
                productSection.appendChild(productCard);
            });

            setupCarousel();

        } catch (error) {
            console.error('Falha ao buscar produtos:', error);
            productSection.innerHTML = '<p>Erro ao carregar os produtos. Verifique se o servidor está rodando.</p>';
        }
    };

    const setupCarousel = () => {
        const scrollAmount = 300;

        nextArrow.addEventListener('click', () => {
            const currentScroll = productSection.scrollLeft;
            const maxScroll = productSection.scrollWidth - productSection.clientWidth;

            if (currentScroll + scrollAmount >= maxScroll) {
                productSection.scrollLeft = 0;
            } else {
                productSection.scrollLeft += scrollAmount;
            }
        });

        prevArrow.addEventListener('click', () => {
            const currentScroll = productSection.scrollLeft;
            const maxScroll = productSection.scrollWidth - productSection.clientWidth;

            if (currentScroll - scrollAmount <= 0) {
                productSection.scrollLeft = maxScroll;
            } else {
                productSection.scrollLeft -= scrollAmount;
            }
        });
    };

    fetchAndRenderProducts();
});
