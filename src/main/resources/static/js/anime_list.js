// Инициализация уведомлений
const notyf = new Notyf({
    duration: 3000,
    position: { x: 'right', y: 'top' },
    types: [
        {
            type: 'success',
            background: '#6C63FF',
            icon: false
        },
        {
            type: 'error',
            background: '#FF6B6B',
            icon: false
        }
    ]
});

// Пример данных аниме (в реальном проекте будут загружаться с сервера)
const animeData = [
    {
        id: 1,
        title: 'Jujutsu Kaisen',
        image: 'https://cdn.myanimelist.net/images/anime/1908/120036.jpg',
        rating: 8.9,
        year: 2023,
        status: 'ongoing',
        genres: ['Action', 'Fantasy']
    },
    {
        id: 2,
        title: 'Demon Slayer',
        image: 'https://cdn.myanimelist.net/images/anime/1286/99889.jpg',
        rating: 8.7,
        year: 2023,
        status: 'ongoing',
        genres: ['Action', 'Supernatural']
    },
    {
        id: 3,
        title: 'Attack on Titan',
        image: 'https://cdn.myanimelist.net/images/anime/1948/120625.jpg',
        rating: 9.1,
        year: 2023,
        status: 'completed',
        genres: ['Action', 'Drama']
    },
    {
        id: 4,
        title: 'Chainsaw Man',
        image: 'https://cdn.myanimelist.net/images/anime/1806/126216.jpg',
        rating: 8.6,
        year: 2022,
        status: 'completed',
        genres: ['Action', 'Supernatural']
    },
    {
        id: 5,
        title: 'Spy x Family',
        image: 'https://cdn.myanimelist.net/images/anime/1441/122795.jpg',
        rating: 8.5,
        year: 2023,
        status: 'ongoing',
        genres: ['Comedy', 'Action']
    },
    {
        id: 6,
        title: 'One Piece',
        image: 'https://cdn.myanimelist.net/images/anime/6/73245.jpg',
        rating: 8.7,
        year: 2023,
        status: 'ongoing',
        genres: ['Adventure', 'Action']
    },
    {
        id: 7,
        title: 'My Hero Academia',
        image: 'https://cdn.myanimelist.net/images/anime/1375/121599.jpg',
        rating: 8.3,
        year: 2023,
        status: 'ongoing',
        genres: ['Action', 'Superhero']
    },
    {
        id: 8,
        title: 'Black Clover',
        image: 'https://cdn.myanimelist.net/images/anime/1364/1231.jpg',
        rating: 8.2,
        year: 2023,
        status: 'ongoing',
        genres: ['Action', 'Fantasy']
    },
    {
        id: 9,
        title: 'Death Note',
        image: 'https://cdn.myanimelist.net/images/anime/9/9453.jpg',
        rating: 8.6,
        year: 2006,
        status: 'completed',
        genres: ['Psychological', 'Thriller']
    },
    {
        id: 10,
        title: 'Fullmetal Alchemist: Brotherhood',
        image: 'https://cdn.myanimelist.net/images/anime/1223/96541.jpg',
        rating: 9.1,
        year: 2009,
        status: 'completed',
        genres: ['Action', 'Adventure']
    },
    {
        id: 11,
        title: 'Tokyo Ghoul',
        image: 'https://cdn.myanimelist.net/images/anime/5/64449.jpg',
        rating: 8.0,
        year: 2014,
        status: 'completed',
        genres: ['Horror', 'Action']
    },
    {
        id: 12,
        title: 'Naruto: Shippuden',
        image: 'https://cdn.myanimelist.net/images/anime/5/17407.jpg',
        rating: 8.2,
        year: 2007,
        status: 'completed',
        genres: ['Action', 'Adventure']
    },
    {
        id: 13,
        title: 'One Punch Man',
        image: 'https://cdn.myanimelist.net/images/anime/12/76049.jpg',
        rating: 8.7,
        year: 2015,
        status: 'completed',
        genres: ['Action', 'Comedy']
    },
    {
        id: 14,
        title: 'Bleach',
        image: 'https://cdn.myanimelist.net/images/anime/3/40451.jpg',
        rating: 8.2,
        year: 2004,
        status: 'completed',
        genres: ['Action', 'Adventure']
    },
    {
        id: 15,
        title: 'Dragon Ball Super',
        image: 'https://cdn.myanimelist.net/images/anime/7/74606.jpg',
        rating: 7.4,
        year: 2015,
        status: 'completed',
        genres: ['Action', 'Adventure']
    },
    {
        id: 16,
        title: 'Hunter x Hunter',
        image: 'https://cdn.myanimelist.net/images/anime/11/33657.jpg',
        rating: 9.0,
        year: 2011,
        status: 'completed',
        genres: ['Action', 'Adventure']
    },
    {
        id: 17,
        title: 'Sword Art Online',
        image: 'https://cdn.myanimelist.net/images/anime/11/39717.jpg',
        rating: 7.5,
        year: 2012,
        status: 'completed',
        genres: ['Action', 'Fantasy']
    },
    {
        id: 18,
        title: 'Code Geass',
        image: 'https://cdn.myanimelist.net/images/anime/5/50331.jpg',
        rating: 8.7,
        year: 2006,
        status: 'completed',
        genres: ['Mecha', 'Drama']
    },
    {
        id: 19,
        title: 'Steins;Gate',
        image: 'https://cdn.myanimelist.net/images/anime/5/73199.jpg',
        rating: 9.1,
        year: 2011,
        status: 'completed',
        genres: ['Sci-Fi', 'Thriller']
    },
    {
        id: 20,
        title: 'Re:Zero',
        image: 'https://cdn.myanimelist.net/images/anime/1522/128039.jpg',
        rating: 8.2,
        year: 2016,
        status: 'completed',
        genres: ['Fantasy', 'Drama']
    }
];

// Функция для создания карточки аниме
function createAnimeCard(anime) {
    return `
        <div class="anime-card" data-aos="fade-up">
            <div class="card-image">
                <img src="${anime.image}" alt="${anime.title}">
                <div class="card-overlay">
                    <div class="card-stats">
                        <span class="rating"><i class="fas fa-star"></i> ${anime.rating}</span>
                        <span class="year">${anime.year}</span>
                    </div>
                    <button class="watch-btn">Смотреть</button>
                </div>
            </div>
            <div class="card-info">
                <h3>${anime.title}</h3>
                <div class="card-tags">
                    ${anime.genres.map(genre => `<span>${genre}</span>`).join('')}
                </div>
            </div>
        </div>
    `;
}

// Функция для отображения аниме в сетке
function renderAnimeGrid(animeList) {
    const grid = document.querySelector('.anime-grid');
    grid.innerHTML = animeList.map(anime => createAnimeCard(anime)).join('');

    // Добавляем обработчики для кнопок просмотра
    document.querySelectorAll('.watch-btn').forEach((btn, index) => {
        btn.addEventListener('click', (e) => {
            e.preventDefault();
            const anime = animeList[index];
            notyf.success(`Открываем ${anime.title}`);
            // Здесь будет редирект на страницу аниме
        });
    });
}

// Обработчики для фильтров
document.querySelector('.apply-filters').addEventListener('click', () => {
    // Здесь будет логика применения фильтров
    notyf.success('Фильтры применены');
});

document.querySelector('.reset-filters').addEventListener('click', () => {
    // Сброс всех фильтров
    document.querySelectorAll('input[type="checkbox"]').forEach(cb => cb.checked = false);
    document.querySelectorAll('input[type="number"]').forEach(input => input.value = '');
    document.querySelector('input[type="range"]').value = 0;
    document.querySelector('.rating-value').textContent = '0+';
    document.querySelector('.status-select').value = 'all';
    notyf.success('Фильтры сброшены');
    renderAnimeGrid(animeData); // Перерисовываем сетку с исходными данными
});

// Обработчик для слайдера рейтинга
const ratingSlider = document.querySelector('input[type="range"]');
const ratingValue = document.querySelector('.rating-value');
ratingSlider.addEventListener('input', (e) => {
    ratingValue.textContent = `${e.target.value}+`;
});

// Обработчики для переключения вида
const gridViewBtn = document.querySelector('.grid-view');
const listViewBtn = document.querySelector('.list-view');
const animeGrid = document.querySelector('.anime-grid');

gridViewBtn.addEventListener('click', () => {
    animeGrid.classList.remove('list-layout');
    gridViewBtn.classList.add('active');
    listViewBtn.classList.remove('active');
});

listViewBtn.addEventListener('click', () => {
    animeGrid.classList.add('list-layout');
    listViewBtn.classList.add('active');
    gridViewBtn.classList.remove('active');
});

// Обработчик для поиска с debounce
let searchTimeout;
const searchInput = document.querySelector('.search-box input');
searchInput.addEventListener('input', (e) => {
    clearTimeout(searchTimeout);
    searchTimeout = setTimeout(() => {
        const searchTerm = e.target.value.toLowerCase();
        const filteredAnime = animeData.filter(anime => 
            anime.title.toLowerCase().includes(searchTerm) ||
            anime.genres.some(genre => genre.toLowerCase().includes(searchTerm))
        );
        renderAnimeGrid(filteredAnime);
    }, 500);
});

// Обработчик для сортировки
const sortSelect = document.querySelector('.sort-select');
sortSelect.addEventListener('change', (e) => {
    const sortedAnime = [...animeData];
    switch(e.target.value) {
        case 'rating':
            sortedAnime.sort((a, b) => b.rating - a.rating);
            break;
        case 'name':
            sortedAnime.sort((a, b) => a.title.localeCompare(b.title));
            break;
        case 'date':
            sortedAnime.sort((a, b) => b.year - a.year);
            break;
        // По умолчанию сортируем по популярности (в данном случае по id)
        default:
            sortedAnime.sort((a, b) => a.id - b.id);
    }
    renderAnimeGrid(sortedAnime);
});

// Обработчики для пагинации
document.querySelectorAll('.page-numbers span').forEach(span => {
    span.addEventListener('click', () => {
        document.querySelector('.page-numbers span.active').classList.remove('active');
        span.classList.add('active');
        // Здесь будет логика загрузки соответствующей страницы
    });
});

// Инициализация начального состояния
document.addEventListener('DOMContentLoaded', () => {
    renderAnimeGrid(animeData);
});
