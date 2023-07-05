/* 
Structure ->  repository table=[{repository link, total requests, open requests, my requests}]
*/
repository_table = [];



// ------------Function for saving the repository data into an array -> (Exercise 1)
function save_table() {
    let table_row = document.getElementsByTagName('tr');

    for (let i = 1; i < table_row.length; i++) {
        let row = {};
        let column = table_row[i].innerHTML;

        repo_link = (column.substring(column.indexOf('<th>') + 4, column.indexOf('</th>')));

        total_req = (column.substring(column.indexOf('<td>') + 4, column.indexOf('</td>')));
        column = column.substring(column.indexOf('</td>') + 5);
        open_req = (column.substring(column.indexOf('<td>') + 4, column.indexOf('</td>')));
        column = column.substring(column.indexOf('</td>') + 5);
        my_req = (column.substring(column.indexOf('<td>') + 4, column.indexOf('</td>')));

        row = { repo_link, total_req, open_req, my_req };
        this.repository_table.push(row);

    }
}


// ---------Function to display the repository names in the list
window.onload = function display_List() {

    let html = "<option disabled selected value>Select the Repository</option>";
    for (let i = 0; i < repository_table.length; i++) {
        html += `<option value='${i}'>${repository_table[i].repo_link}</option>`;
    }
    //console.log(html);
    document.getElementById('countQueryRepositoryInput').innerHTML = html;
    console.log(document.getElementById('countQueryRepositoryInput'));
}



//----------Function to perform search operation and display an alert
function issue() {
    //save_table();
    let repo_name = document.getElementById('countQueryRepositoryInput');
    let issue_type = document.getElementById('countQueryIssueType');

    let issue_number = Number;
    if (issue_type.options[issue_type.selectedIndex].text === 'Total') {
        issue_number = repository_table[repo_name.value].total_req;
    }
    else if (issue_type.options[issue_type.selectedIndex].text === 'Open') {
        issue_number = repository_table[repo_name.value].open_req;
    }
    else {
        issue_number = repository_table[repo_name.value].my_req;
    }
    alert(issue_number);
}



function load_data_from_gitlab() {

}



function display_gitlab_data() {

}

module.exports = {
    issue,
    save_table,

};
