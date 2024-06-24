package my_base;


import base.PeriodicLoop;


public class MyPeriodicLoop extends PeriodicLoop {

	private MyContent content;
	private int loopCounterTarget = 0;

	private int limitLoopTarget = 8;

	public void setContent(MyContent content) {
		this.content = content;
	}
	
	@Override
	public void execute() {
		// Let the super class do its work first
		super.execute();
		content.fire();

		content.getGameManager().getTargetsManager().moveAllTargets(content.getGameManager().getLevel());
		if(loopCounterTarget == 0) {
			content.getGameManager().getTargetsManager().addTarget();
		}
		loopCounterTarget++;
		if(loopCounterTarget == limitLoopTarget) {
			loopCounterTarget = 0;
		}
		content.getGameManager().getTargetsManager().getTargets().forEach(target -> {
			if(target.getLocation().y > 800) {
				content.getGameManager().getTargetsManager().removeTarget(target);
			}
			if(content.isSpaceshipHit(target)) {
				System.out.println("spaceship hit " + target.getImageID());
				content.getGameManager().getTargetsManager().removeTarget(target);
				content.getGameManager().decreaseLife();
				if(content.getGameManager().getLives() == 0) {
					content.getGameManager().gameOver();
				}
			}
		});

	}

}
