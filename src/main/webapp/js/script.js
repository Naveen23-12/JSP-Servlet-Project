function validateForm() {
    var name = document.forms[0]["name"].value;
    var email = document.forms[0]["email"].value;
    var salary = document.forms[0]["salary"].value;

    if (name == "" || email == "" || salary == "") {
        alert("All fields must be filled out");
        return false;
    }
    if (salary <= 0) {
        alert("Salary must be positive");
        return false;
    }
    return true;
}

function confirmDelete() {
    return confirm("Are you sure you want to delete this employee?");
}
