const _store = 'darkmode';
const _class = 'dark-mode';
const _topmenu = $('#topmenu');

$(document).ready(checkDarkTheme());

$('#btnTheme1').on("click", function() {
    $('body').toggleClass(_class);
    localStorage.setItem(_store, $('body').hasClass(_class) ? 1 : 0)
    checkDarkTheme();
});

$('#btnTheme2').on("click", function() {
    $('body').toggleClass(_class);
    localStorage.setItem(_store, $('body').hasClass(_class) ? 1 : 0)
    checkDarkTheme();
});

$('#btnMenu').on('click', function() {
    $('body').toggleClass('lock-scroll');
    _topmenu.removeAttr('style');
    if (_topmenu.hasClass('menu-open')) {
        _topmenu.removeClass('menu-open');
        _topmenu.addClass('menu-close');
    }
    else {
        _topmenu.removeClass('menu-close');
        _topmenu.addClass('menu-open');
    }
});

function checkDarkTheme() {
    let dm = localStorage.getItem(_store);
    let match = window.matchMedia('(prefers-color-scheme: dark)');
    
    if (dm === null) {
        if (window.matchMedia && match.matches) {
            $('body').addClass(_class);
        }
        match.addEventListener('change', () => {
            $('body').toggleClass(_class);
            onClassContain();
        })
    }
    else {
        if (Number(dm) == 1) {
            $('body').addClass(_class);
        }
    }
    onClassContain();
}

function onClassContain() {
    if ($('body').hasClass(_class)) {
        $('#btnTheme1').html('<i class="fa-solid fa-sun"></i>').attr("title","Change to light theme");
        $('#btnTheme2').html('<i class="fa-solid fa-sun"></i>').attr("title","Change to light theme");
    }
    else {
        $('#btnTheme1').html('<i class="fa-solid fa-moon"></i>').attr("title","Change to dark theme");
        $('#btnTheme2').html('<i class="fa-solid fa-moon"></i>').attr("title","Change to dark theme");
    }
}