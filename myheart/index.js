const texts = [
    'I Love You',                // English
    '사랑해요',                   // Korean
    'Je t\'aime',                // French
    'Te quiero',                 // Spanish
    'Ich liebe dich',            // German
    'Eu te amo',                 // Portuguese
    '我爱你',                     // Chinese
    '愛してる',                   // Japanese
    'Tôi yêu bạn',               // Vietnamese
    'ฉันรักคุณ',                 // Thai
    'Я тебя люблю',              // Russian
    'Ti amo',                    // Italian
    'Ik hou van jou',            // Dutch
    'Jeg elsker dig',            // Danish
    'Jeg elsker deg',            // Norwegian
    'Jag älskar dig',            // Swedish
    'Aš tave myliu',             // Lithuanian
    'Szeretlek',                 // Hungarian
    'Kocham cię',                // Polish
    'Σ\'αγαπώ',                  // Greek
    'Te iubesc',                 // Romanian
    'Te amo',                    // Latin
    'Mahal kita',                // Filipino
    'Aku cinta kamu',            // Indonesian
    'I love you so much',
    "<3"
];
const container = document.querySelector('.falling-text-container');

function createFallingText() {
    const span = document.createElement('span');
    span.className = 'falling-text red-char'; // Luôn là màu đỏ
    span.textContent = texts[Math.floor(Math.random() * texts.length)];

    // Random vị trí X (theo viewport width), Z (theo px)
    const x = Math.random() * 90 + 'vw';
    const z = (Math.random() * 800 - 400) + 'px';

    span.style.setProperty('--x', x);
    span.style.setProperty('--z', z);
    span.style.animationDuration = (2 + Math.random() * 2) + 's';

    container.appendChild(span);

    span.addEventListener('animationend', () => {
        span.remove();
    });
}

setInterval(()=> {
    createFallingText();
    createFallingText();
    createFallingText();
    createFallingText();
    createFallingText();
    createFallingText();
    createFallingText();
    createFallingText();
},200); // Tạo  chữ mỗi 200ms

// Điều chỉnh góc nhìn (perspective) bằng slider
const slider = document.getElementById('perspective-slider');
const valueLabel = document.getElementById('perspective-value');
const fallingContainer = document.querySelector('.falling-text-container');

slider.addEventListener('input', function() {
    fallingContainer.style.perspective = this.value + 'px';
    valueLabel.textContent = this.value;
});

// Tạo nền lấp lánh
const starsContainer = document.querySelector('.stars');
for (let i = 0; i < 120; i++) {
    const star = document.createElement('div');
    star.className = 'star';
    resetStar(star, true);
    starsContainer.appendChild(star);

    // Khi animation kết thúc, random lại vị trí và delay
    star.addEventListener('animationiteration', () => {
        resetStar(star, false);
    });
}

function resetStar(star, firstTime) {
    star.style.left = Math.random() * 100 + 'vw';
    star.style.setProperty('--z', (Math.random() * 800 - 400) + 'px');
    star.style.setProperty('--scale', 0.5 + Math.random() * 1.5);
    // Đặt lại top về đầu nếu không phải lần đầu
    if (!firstTime) {
        star.style.top = '-2px';
    }
    // Random delay cho hiệu ứng tự nhiên
    star.style.animationDelay = (Math.random() * 8) + 's';
}