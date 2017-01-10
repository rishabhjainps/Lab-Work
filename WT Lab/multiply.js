function main(input) {
    var numb= input.split(/\r?\n/);
    var arr=numb[0].split(" ");
    var arr2=numb[1].split(" ");

    var questions=parseInt(arr[0]);
    var level=parseInt(arr[1]);
    var count=0;
    var flag=0;
    for(var i=0; i<questions ;i++)
    {
        if(parseInt(arr2[i])<=level)
        {
            count++;
        }
        else
        {

            if(flag==1)
                break;
            flag=1;
        }

    }
    process.stdout.write(count + '\n');
}

process.stdin.resume();
process.stdin.setEncoding("utf-8");
var stdin_input = "";

process.stdin.on("data", function (input) {
    stdin_input += input;
});

process.stdin.on("end", function () {
    main(stdin_input);
});

