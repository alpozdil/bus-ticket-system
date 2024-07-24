document.querySelectorAll('input[name="trip"]').forEach(radio => {
    radio.addEventListener('change', function () {
        const returnDate = document.querySelector('.return-date');
        if (this.value === 'round-trip') {
            returnDate.style.display = 'block';
        } else {
            returnDate.style.display = 'none';
        }
    });
});
