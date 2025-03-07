function Challenge({challenge}){
    return (
        <div>
            <h3>{challenge.month}</h3>
            <p>{challenge.description}</p>
        </div>
    );
}

export default Challenge;