var dateInput = document.getElementById('floatingInput1');

dateInput.addEventListener('input', function(event) {

    var input = event.target.value;

    input = input.replace(/\D/g, '');
    input = input.substring(0, 8);

    if (input.length > 2) {
        input = input.substring(0, 2) + '/' + input.substring(2);
    }
    if (input.length > 5) {
        input = input.substring(0, 5) + '/' + input.substring(5);
    }

    event.target.value = input;
});
