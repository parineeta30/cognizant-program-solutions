import React from 'react';
import { useParams } from 'react-router-dom';
import trainersMock from '../trainersMock';
 

const TrainerDetail = () => {
  const { id } = useParams();
  const trainer = trainersMock.find(t => t.trainerId === id);

  if (!trainer) return <div>Trainer not found</div>;

  return (
  <div>
    <h3>{trainer.name} (<span>{trainer.specialization}</span>)</h3>
    <p>{trainer.email}</p>
    <p>{trainer.phone}</p>
    <ul>
      {trainer.skills.map(skill => (
        <li key={skill}>{skill}</li>
      ))}
    </ul>
  </div>
);

}

export default TrainerDetail;
