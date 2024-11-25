// Initialize AOS (Animate On Scroll)
AOS.init({
    duration: 800,
    easing: 'ease-out',
    once: true
});

// Navbar scroll effect
const navbar = document.querySelector('.navbar');
let lastScroll = 0;

window.addEventListener('scroll', () => {
    const currentScroll = window.pageYOffset;
    
    if (currentScroll <= 0) {
        navbar.style.background = 'rgba(10, 10, 10, 0.8)';
        return;
    }
    
    if (currentScroll > lastScroll && currentScroll > 70) {
        // Scrolling down
        navbar.style.transform = 'translateY(-100%)';
    } else {
        // Scrolling up
        navbar.style.transform = 'translateY(0)';
        navbar.style.background = 'rgba(10, 10, 10, 0.95)';
    }
    
    lastScroll = currentScroll;
});

// Smooth scroll for anchor links
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function(e) {
        e.preventDefault();
        const target = document.querySelector(this.getAttribute('href'));
        if (target) {
            target.scrollIntoView({
                behavior: 'smooth',
                block: 'start'
            });
        }
    });
});

// Parallax effect for hero section
const hero = document.querySelector('.hero');
const heroContent = document.querySelector('.hero-content');
window.addEventListener('scroll', () => {
    const scroll = window.pageYOffset;
    heroContent.style.transform = `translateY(${scroll * 0.5}px)`;
    heroContent.style.opacity = 1 - scroll / 700;
    if (scroll > 50) {
        hero.classList.add('scrolled');
    } else {
        hero.classList.remove('scrolled');
    }
});

// Dynamic video loading for better performance
document.addEventListener('DOMContentLoaded', () => {
    const video = document.querySelector('.hero-video');
    video.play().catch(function(error) {
        console.log("Video autoplay failed:", error);
    });
});

// Anime cards hover effect enhancement
const animeCards = document.querySelectorAll('.anime-card');
animeCards.forEach(card => {
    card.addEventListener('mouseenter', () => {
        card.style.transform = 'translateY(-10px) scale(1.02)';
    });
    
    card.addEventListener('mouseleave', () => {
        card.style.transform = 'translateY(0) scale(1)';
    });
});

// Search functionality
const searchBtn = document.querySelector('.search-btn');
let searchOpen = false;

searchBtn.addEventListener('click', () => {
    if (!searchOpen) {
        const overlay = document.createElement('div');
        overlay.className = 'search-overlay';
        
        const searchBox = document.createElement('div');
        searchBox.className = 'search-box';
        
        const searchInput = document.createElement('input');
        searchInput.type = 'text';
        searchInput.placeholder = 'Поиск фильма...';
        searchInput.className = 'search-input';
        
        searchBox.appendChild(searchInput);
        overlay.appendChild(searchBox);
        document.body.appendChild(overlay);
        document.body.style.overflow = 'hidden';
        
        setTimeout(() => {
            overlay.style.opacity = '1';
            searchInput.focus();
        }, 10);

        // Handle search on Enter
        searchInput.addEventListener('keypress', (e) => {
            if (e.key === 'Enter' && searchInput.value.trim() !== '') {
                const searchTerm = searchInput.value.trim();
                window.location.href = `/movie-list/${searchTerm}/1`;
            }
        });

        // Close on overlay click
        overlay.addEventListener('click', (e) => {
            if (e.target === overlay) {
                closeSearch(overlay);
            }
        });

        // Close on Escape
        document.addEventListener('keydown', (e) => {
            if (e.key === 'Escape') {
                closeSearch(overlay);
            }
        });

        searchOpen = true;
    }
});

function closeSearch(overlay) {
    overlay.style.opacity = '0';
    setTimeout(() => {
        document.body.removeChild(overlay);
        document.body.style.overflow = 'auto';
    }, 300);
    searchOpen = false;
}

// Add search overlay styles dynamically
const style = document.createElement('style');
style.textContent = `
    .search-overlay {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: rgba(0, 0, 0, 0.9);
        display: flex;
        align-items: center;
        justify-content: center;
        z-index: 1000;
        opacity: 0;
        transition: opacity 0.3s ease;
    }
    
    .search-box {
        width: 90%;
        max-width: 600px;
        padding: 20px;
    }
    
    .search-input {
        width: 100%;
        padding: 15px 20px;
        font-size: 1.5rem;
        color: #fff;
        background: transparent;
        border: none;
        border-bottom: 2px solid rgba(255, 255, 255, 0.2);
        outline: none;
        transition: all 0.3s ease;
    }
    
    .search-input:focus {
        border-bottom-color: var(--primary-color);
    }
    
    .search-input::placeholder {
        color: rgba(255, 255, 255, 0.5);
    }
`;
document.head.appendChild(style);

// Login button effect
const loginBtn = document.querySelector('.login-btn');
loginBtn.addEventListener('mouseenter', () => {
    loginBtn.style.transform = 'translateY(-3px)';
    loginBtn.style.boxShadow = '0 5px 15px rgba(108, 99, 255, 0.4)';
});

loginBtn.addEventListener('mouseleave', () => {
    loginBtn.style.transform = 'translateY(0)';
    loginBtn.style.boxShadow = 'none';
});

// Upcoming Section Animation
const upcomingCards = document.querySelectorAll('.upcoming-card');
upcomingCards.forEach(card => {
    card.addEventListener('mouseenter', () => {
        card.style.transform = 'scale(1.02)';
    });
    card.addEventListener('mouseleave', () => {
        card.style.transform = 'scale(1)';
    });
});

// Newsletter Form Handling
const newsletterForm = document.querySelector('.newsletter-form');
if (newsletterForm) {
    newsletterForm.addEventListener('submit', (e) => {
        e.preventDefault();
        const email = newsletterForm.querySelector('input[type="email"]').value;
        // Here you would typically send this to your backend
        alert('Спасибо за подписку! Мы будем держать вас в курсе новинок.');
        newsletterForm.reset();
    });
}

// Notification Button Animation
const notifyBtns = document.querySelectorAll('.notify-btn');
notifyBtns.forEach(btn => {
    btn.addEventListener('click', function() {
        this.innerHTML = '<i class="fas fa-check"></i> Уведомление включено';
        this.style.background = '#28a745';
        this.disabled = true;
    });
});

// User Card Hover Effects
const userCards = document.querySelectorAll('.user-card');
userCards.forEach(card => {
    card.addEventListener('mouseenter', () => {
        card.style.transform = 'translateY(-5px)';
    });
    card.addEventListener('mouseleave', () => {
        card.style.transform = 'translateY(0)';
    });
});

// Footer Social Links Animation
const socialLinks = document.querySelectorAll('.social-links a');
socialLinks.forEach(link => {
    link.addEventListener('mouseenter', () => {
        link.style.transform = 'translateY(-3px) rotate(5deg)';
    });
    link.addEventListener('mouseleave', () => {
        link.style.transform = 'translateY(0) rotate(0)';
    });
});

// App Buttons Hover Effect
const appButtons = document.querySelectorAll('.app-button');
appButtons.forEach(button => {
    button.addEventListener('mouseenter', () => {
        button.style.transform = 'translateY(-2px)';
    });
    button.addEventListener('mouseleave', () => {
        button.style.transform = 'translateY(0)';
    });
});

// Scroll to Top Button
const scrollTopBtn = document.createElement('button');
scrollTopBtn.innerHTML = '<i class="fas fa-arrow-up"></i>';
scrollTopBtn.className = 'scroll-top-btn';
document.body.appendChild(scrollTopBtn);

window.addEventListener('scroll', () => {
    if (window.pageYOffset > 300) {
        scrollTopBtn.style.opacity = '1';
        scrollTopBtn.style.visibility = 'visible';
    } else {
        scrollTopBtn.style.opacity = '0';
        scrollTopBtn.style.visibility = 'hidden';
    }
});

scrollTopBtn.addEventListener('click', () => {
    window.scrollTo({
        top: 0,
        behavior: 'smooth'
    });
});

// Add styles for scroll to top button
const styleScrollTop = document.createElement('style');
styleScrollTop.textContent = `
    .scroll-top-btn {
        position: fixed;
        bottom: 30px;
        right: 30px;
        width: 50px;
        height: 50px;
        border-radius: 50%;
        background: var(--primary-color);
        color: white;
        border: none;
        cursor: pointer;
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 1.2rem;
        opacity: 0;
        visibility: hidden;
        transition: all 0.3s ease;
        z-index: 1000;
    }
    
    .scroll-top-btn:hover {
        transform: translateY(-5px);
        box-shadow: 0 5px 15px rgba(108, 99, 255, 0.3);
    }
    
    @media (max-width: 768px) {
        .scroll-top-btn {
            bottom: 20px;
            right: 20px;
            width: 40px;
            height: 40px;
            font-size: 1rem;
        }
    }
`;
document.head.appendChild(styleScrollTop);
