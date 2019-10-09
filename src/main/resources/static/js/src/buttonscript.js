// Variables

var playerScore = 0;
var c = document.getElementById("gameCanvas");
var ctx = c.getContext("2d");
// GameBall
var x = c.width / 2;
var y = c.height - 30;
var dx = 2;
var dy = -2;
var radius = 10;
// sPad
var playerPadHeight = 10
var playerPadWidth = 75
var padX = (c.width - playerPadWidth / 2);
var padY = (c.height - 30);

// PlayerControls
var pressRight = false
var pressLeft = false
// Bricks
var rowHeight = 3;
var brickColumnWidth = 5;
var brickWidth = 75;
var brickHeight = 20;
var brickPadding = 10;
var brickOffsetTop = 30;
var brickOffsetLeft = 30;
var bricks = [];

function brickCollision() {
	for (var c = 0; c < brickColumnWidth; c++) {
		for (var r = 0; r < rowHeight; r++) {
			var b = bricks[c][r];
			if (b.status == 1) {
				if (x > b.x && x < b.x + brickWidth && y > b.y && y < b.y + brickHeight) {
					dy = -dy;
					b.status = 0;
					playerScore =playerScore + 10;
					document.getElementById('playerScore').innerHTML = playerScore;
				}
			}
		}
	}
}

function drawBricks() {
	
	for (var c = 0; c < brickColumnWidth; c++) {
		for (var r = 0; r < rowHeight; r++) {
			if(bricks[c][r].status == 1 ){
			var brickX = (c * (brickWidth + brickPadding)) + brickOffsetLeft;
			var brickY = (r * (brickHeight + brickPadding)) + brickOffsetTop;
			bricks[c][r].x = brickX;
			bricks[c][r].y = brickY;
			ctx.beginPath();
			ctx.rect(brickX, brickY, brickWidth, brickHeight);
			ctx.fillStyle = "#f7022a";
			ctx.fill();
			ctx.closePath();
			}
		}
	}
}

function keyDownHandler(e) {
	if (e.key == "Right" || e.key == "ArrowRight") {
		pressRight = true;
	} else if (e.key == "Left" || e.key == "ArrowLeft") {
		pressLeft = true;
	}
}

function keyUpHandler(e) {
	if (e.key == "Right" || e.key == "ArrowRight") {
		pressRight = false;
	} else if (e.key == "Left" || e.key == "ArrowLeft") {
		pressLeft = false;
	}
}

function checkPress() {
	if (pressRight) {
		padX += 7;
		if (padX + playerPadWidth > c.width) {
			padX = c.width - playerPadWidth;
		}
	} else if (pressLeft) {
		padX -= 7;
		if (padX < 0) {
			padX = 0;
		}
	}
}

function drawPlayerPad() {
	ctx.beginPath();
	ctx.rect(padX, c.height - playerPadHeight, playerPadWidth, playerPadWidth);
	ctx.fillStyle = "#f7022a";
	ctx.fill();
	ctx.closePath();
}

function drawBall() {
	ctx.beginPath();
	ctx.arc(x, y, radius, 0, Math.PI * 2);
	ctx.fillStyle = "#f25757";
	ctx.shadowColor = "red";
	ctx.shadowBlur = 40;
	ctx.stroke();
	ctx.fill();
	ctx.closePath();

}

function collisionDetection() {
	if (x + dx > c.width - radius || x + dx < radius) {
		dx = -dx;
	}
	if (y + dy < radius) {
		dy = -dy;
	} else if (y + dy > c.height - radius) {

		if (x > padX && x < padX + playerPadWidth) {
			dy = -dy;
		} else {
			var refresh = confirm("Your score was: " + playerScore + "\nSubmit score with ok\nCancel to play again");
			
			if(refresh == true){
			document.getElementById("runscore").value = playerScore;	
			document.scoreForm.submit();
			}
			else {
			document.location.reload();
			clearInterval(interval);
			main();
			}
		}
	}
}

function draw() {
	ctx.clearRect(0, 0, c.width, c.height);
	drawPlayerPad();
	drawBall();
	drawBricks();
	collisionDetection();
	brickCollision();
	checkPress();
	x += dx;
	y += dy;
}

function theBricks(){
	for (var c = 0; c < brickColumnWidth; c++) {
		bricks[c] = [];
		for (var r = 0; r < rowHeight; r++) {
			bricks[c][r] = { x: 0, y: 0, status: 1 };
		}
	}
}

function main() {
	theBricks();
	var interval = setInterval(draw, 10);
	setInterval(draw,10);
	document.addEventListener("keydown", keyDownHandler, false);
	document.addEventListener("keyup", keyUpHandler, false);
}

theBricks();
drawBricks();
drawPlayerPad();
drawBall();